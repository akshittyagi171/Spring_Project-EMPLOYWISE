package com.employee_wise.assignment.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee_wise.assignment.entity.Employee;

// TODO are we using MongoDB? If not, why we are using MongoRepo?
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// https://hevodata.com/learn/spring-boot-mysql/
@Repository
public interface EmployeeRepo extends MongoRepository<Employee , UUID>{
	
}
