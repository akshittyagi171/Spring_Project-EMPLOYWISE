package com.employee_wise.assignment.response;

import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO migrate to Java 17 Record
// Also probably not needed
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class EmailResponse{
	
	private String recipentMail;
	private String message;

}