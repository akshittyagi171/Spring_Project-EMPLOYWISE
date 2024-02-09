package com.employee_wise.assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee_wise.assignment.constants.ErrorCodeEnum;
import com.employee_wise.assignment.pojo.EmployeeError;

@ControllerAdvice
public class EmployeeExceptionHandler extends RuntimeException{
	
	static final long serialVersionUID = 1L;

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<EmployeeError> handleValidationException(EmployeeException ex) {
		EmployeeError response = EmployeeError.builder().errorCode(ex.getErrorCode())
				.errorMessage(ex.getErrorMessage()).build();
		return new ResponseEntity<>(response, ex.getHttpStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<EmployeeError> handleGenericException(Exception ex) {
		EmployeeError paymentResponse = EmployeeError.builder()
				.errorCode(ErrorCodeEnum.GENERIC_EXCEPTION.getErrorCode())
				.errorMessage(ErrorCodeEnum.GENERIC_EXCEPTION.getErrorMessage())
				.build();
		return new ResponseEntity<>(paymentResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
