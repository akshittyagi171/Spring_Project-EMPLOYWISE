package com.employee_wise.assignment.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO migrate this to Record too - Java 17 Records
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Employee {
	
	@Id
	@Indexed(unique = true)
	private UUID id = UUID.randomUUID();
	private String employeeName;
	private String phoneNumber;
	private String email;
	private UUID reportsTo;
	private String profileImage;
	
}
