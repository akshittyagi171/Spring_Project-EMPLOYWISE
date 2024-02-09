package com.employee_wise.assignment.exceptions;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeException extends RuntimeException {
	private static final long serialVersionUID = -2171272011475853092L;
	private HttpStatus httpStatus;
	private String errorCode;
	private String errorMessage;

}
