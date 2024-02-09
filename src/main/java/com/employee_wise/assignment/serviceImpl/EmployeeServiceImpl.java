package com.employee_wise.assignment.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employee_wise.assignment.constants.ErrorCodeEnum;
import com.employee_wise.assignment.entity.Employee;
import com.employee_wise.assignment.exceptions.EmployeeException;
import com.employee_wise.assignment.repository.EmployeeRepo;
import com.employee_wise.assignment.response.PostEmployeeResponse;
import com.employee_wise.assignment.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;
	
	@Value("${Maximum_Number_Of_Levels}")
	private int MAX_LEVEL;
	
	@Value("${Base_Condition_for_levels}")
	private int BASE_LEVEL;
	
	@Override
	public PostEmployeeResponse addEmployee(Employee emp) {
		Employee saveEmp = this.repo.save(emp);
		if(saveEmp == null) {
			throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
					ErrorCodeEnum.EMPLOYEE_NOT_ADDED.getErrorCode(),
					ErrorCodeEnum.EMPLOYEE_NOT_ADDED.getErrorMessage());
		}
		return new PostEmployeeResponse(saveEmp.getId().toString(), "Employee is Generated");
	}
	
	@Override
	public Employee getEmployeeById(String Id) {
		UUID uuid = UUID.fromString(Id);
	    Optional<Employee> optionalEmployee = this.repo.findById(uuid).stream().findFirst();
	    
	    if (!optionalEmployee.isPresent()) {
	        throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
	                ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getErrorCode(),
	                ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getErrorMessage());
	    }
	    
	    Employee employee = optionalEmployee.get();
	    return employee;
	}
	
	@Override
	public List<Employee> getAllEmployee(Integer pageNumber, Integer pageSize, String sortBy) {
		
		Pageable page = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		Page<Employee> pageEmp = this.repo.findAll(page);
		List<Employee> getAllEmp = pageEmp.getContent();
		
		if(getAllEmp == null) {
			throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
					ErrorCodeEnum.EMPLOYEES_NOT_FOUND.getErrorCode(),
					ErrorCodeEnum.EMPLOYEES_NOT_FOUND.getErrorMessage());
		}
		return getAllEmp;
	}

	@Override
	public Employee deleteEmployeeById(String id) {
		UUID uuid = UUID.fromString(id);
		List<Employee> emp = this.repo.findById(uuid).stream().collect(Collectors.toList());
		this.repo.deleteById(uuid);
		return emp.get(0);
	}

	@Override
	public PostEmployeeResponse updateEmployeeById(String id, Employee emp) {
		UUID uuid = UUID.fromString(id);
		List<Employee> empl = this.repo.findById(uuid).stream().collect(Collectors.toList());
		Employee employee = empl.get(0);
		if(employee == null) {
			throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
					ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getErrorCode(),
					ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getErrorMessage());
		}
		else {
			if(emp.getEmployeeName() != null) {
				employee.setEmployeeName(emp.getEmployeeName());
			}
			if(emp.getEmail() != null) {
				employee.setEmail(emp.getEmail());
			}
			if(emp.getPhoneNumber() != null) {
				employee.setPhoneNumber(emp.getPhoneNumber());
			}
			if(emp.getReportsTo() != null) {
				employee.setReportsTo(emp.getReportsTo());
			}
			if(emp.getProfileImage() != null) {
				employee.setProfileImage(emp.getProfileImage());
			}
		}

		Employee saveEmp = this.repo.save(employee);
		if(saveEmp == null) {
			throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
					ErrorCodeEnum.EMPLOYEE_NOT_UPDATED.getErrorCode(),
					ErrorCodeEnum.EMPLOYEE_NOT_UPDATED.getErrorMessage());
		}
		return new PostEmployeeResponse(saveEmp.getId().toString(), "Employee is Updated");
	}
	
	@Override
	public PostEmployeeResponse getNthManager(String id, Integer n) {
	    UUID uuid = UUID.fromString(id);
	    Optional<Employee> optionalEmployee = this.repo.findById(uuid).stream().findFirst();
	    
	    if (!optionalEmployee.isPresent()) {
	        throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
	                ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getErrorCode(),
	                ErrorCodeEnum.EMPLOYEE_NOT_FOUND.getErrorMessage());
	    }
	    
	    Employee employee = optionalEmployee.get();
	    
	    if (n > MAX_LEVEL || n <= BASE_LEVEL) {
	        throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
	                ErrorCodeEnum.NO_VALID_LEVEL.getErrorCode(),
	                ErrorCodeEnum.NO_VALID_LEVEL.getErrorMessage());
	    }
	    
	    Employee manager = findNthManager(employee, n);
	    
	    if (manager != null) {
	        return new PostEmployeeResponse(manager.getId().toString(), "The Requested Manager is found and his name is "+ manager.getEmployeeName()+".");
	    } else {
	        throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
	                ErrorCodeEnum.MANAGER_NOT_FOUND.getErrorCode(),
	                ErrorCodeEnum.MANAGER_NOT_FOUND.getErrorMessage());
	    }
	}

	private Employee findNthManager(Employee employee, int n) {
	    UUID managerId = employee.getReportsTo();
	    
	    while (managerId != null && n > BASE_LEVEL) {
	        Optional<Employee> optionalManager = this.repo.findById(managerId).stream().findFirst();
	        
	        if (!optionalManager.isPresent()) {
	        	throw new EmployeeException(HttpStatus.INTERNAL_SERVER_ERROR,
		                ErrorCodeEnum.MANAGER_NOT_FOUND.getErrorCode(),
		                ErrorCodeEnum.MANAGER_NOT_FOUND.getErrorMessage());
	        }
	        
	        employee = optionalManager.get();
	        managerId = employee.getReportsTo();
	        n--;
	    }
	    
	    return employee;
	}
}
