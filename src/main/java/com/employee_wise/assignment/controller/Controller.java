package com.employee_wise.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee_wise.assignment.constants.EndPoint;
import com.employee_wise.assignment.entity.EmailDetails;
import com.employee_wise.assignment.entity.Employee;
import com.employee_wise.assignment.response.EmailResponse;
import com.employee_wise.assignment.response.PostEmployeeResponse;
import com.employee_wise.assignment.service.EmailService;
import com.employee_wise.assignment.service.EmployeeService;

@RestController
@RequestMapping(EndPoint.EMPLOYEE)
public class Controller {
	
	@Autowired
	private EmployeeService empSerImp;
	
	@Autowired 
	private EmailService emailService;
	
	@PostMapping(EndPoint.ADD_EMPLOYEE)
	public ResponseEntity<PostEmployeeResponse> addEmployee(@RequestBody Employee emp){
		
		 PostEmployeeResponse savedEmp = this.empSerImp.addEmployee(emp);
		 return new ResponseEntity<PostEmployeeResponse>(savedEmp,HttpStatus.CREATED); 
	}
	
	@GetMapping(EndPoint.GET_EMPLOYEE_BY_ID+ "/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id){
		
		 Employee returnedEmp = this.empSerImp.getEmployeeById(id);
		 return new ResponseEntity<Employee>(returnedEmp,HttpStatus.FOUND); 
	}
	
	@GetMapping(EndPoint.GET_ALL_EMPLOYEE)
	public ResponseEntity<List<Employee>> getAllEmployee(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = "employeeName", required = false) String sortBy
			){
		
		 List<Employee> returnedEmp = this.empSerImp.getAllEmployee(pageNumber, pageSize, sortBy);
		 return new ResponseEntity<List<Employee>>(returnedEmp,HttpStatus.FOUND); 
	}
	
	@PutMapping(EndPoint.UPDATE_EMPLOYEE_BY_ID + "/{id}")
	public ResponseEntity<PostEmployeeResponse> updateEmployeeById(@PathVariable("id") String id, @RequestBody Employee emp){
		PostEmployeeResponse updatedEmp = this.empSerImp.updateEmployeeById(id, emp);
		return new ResponseEntity<PostEmployeeResponse>(updatedEmp,HttpStatus.OK);
	}
	
	@DeleteMapping(EndPoint.DELETE_EMPLOYEE_BY_ID+"/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable String id){
		
		 Employee getAllEmp = this.empSerImp.deleteEmployeeById(id);
		 return new ResponseEntity<>(getAllEmp,HttpStatus.OK);
		 
	}
	
	@GetMapping(EndPoint.GET_MANAGER_BY_NTH_LEVEL+ "/{id}" + "/{n}")
	public ResponseEntity<PostEmployeeResponse> getNthManager(@PathVariable("id") String id, @PathVariable("n") Integer n){
		PostEmployeeResponse Emp = this.empSerImp.getNthManager(id, n);
		return new ResponseEntity<PostEmployeeResponse>(Emp,HttpStatus.OK);
	}
	
	@PostMapping(EndPoint.SEND_SIMPLE_MAIL)
    public ResponseEntity<EmailResponse> sendMail(@RequestBody EmailDetails details)
    {
        EmailResponse status = emailService.sendSimpleMail(details);
        return new ResponseEntity<EmailResponse>(status,HttpStatus.OK);
    }

    @PostMapping(EndPoint.SEND_MAIL_WITH_ATTACHMENT)
    public ResponseEntity<EmailResponse> sendMailWithAttachment(@RequestBody EmailDetails details)
    {
        EmailResponse status = emailService.sendMailWithAttachment(details);
        return new ResponseEntity<EmailResponse>(status,HttpStatus.OK);
    }
	
}
