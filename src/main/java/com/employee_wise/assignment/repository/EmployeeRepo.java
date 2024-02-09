package com.employee_wise.assignment.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee_wise.assignment.entity.Employee;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee , UUID>{
	
}
