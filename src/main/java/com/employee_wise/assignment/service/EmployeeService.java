package com.employee_wise.assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee_wise.assignment.entity.Employee;
import com.employee_wise.assignment.response.PostEmployeeResponse;

@Service
public interface EmployeeService {

	public PostEmployeeResponse addEmployee(Employee emp);
	public List<Employee> getAllEmployee(Integer pageNumber, Integer pageSize, String sortBy);
	public Employee getEmployeeById(String Id);
	public PostEmployeeResponse updateEmployeeById(String id,Employee emp);
	public Employee deleteEmployeeById(String id);
	public PostEmployeeResponse getNthManager(String id, Integer n);
}
