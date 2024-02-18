package com.employee_wise.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_wise.assignment.entity.Employee;
import com.employee_wise.assignment.response.PostEmployeeResponse;

@Service
public interface EmployeeService {

	// TODO, refactor to return the new created employee id
	PostEmployeeResponse addEmployee(Employee emp);
	List<Employee> getAllEmployee(Integer pageNumber, Integer pageSize, String sortBy);
	Employee getEmployeeById(String Id);
	PostEmployeeResponse updateEmployeeById(String id,Employee emp);
	Employee deleteEmployeeById(String id);

	// TODO refactor to return the Employee, not this
	PostEmployeeResponse getNthManager(String id, Integer n);
}
