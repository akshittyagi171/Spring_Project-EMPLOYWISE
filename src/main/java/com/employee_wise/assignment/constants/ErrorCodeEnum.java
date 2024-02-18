package com.employee_wise.assignment.constants;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
	GENERIC_EXCEPTION("10001","Something went wrong, please try later"),
	EMPLOYEE_NOT_ADDED("10002","Failed request, Employee Cannot added"),
	EMPLOYEE_NOT_FOUND("10003","Failed Request, Employee with the given UUID Not Found"),
	EMPLOYEES_NOT_FOUND("10004","Failed Request, Employees Not Found"),
	EMPLOYEE_NOT_UPDATED("10005","Failed Request, Employee cannot be updated"),
	NO_VALID_LEVEL("10006","Failed Request, Number of level is greater than Maximum Levels or lesser than 1 level in Organisation"),
	MANAGER_NOT_FOUND("10007","Failed Request, Requested Manager could not be found"),
	MAIL_NOT_SENT("10008","Failed Request, Mail could not be sent to the Reciepent");
	
	
	private final String errorCode;
	private final String errorMessage;
	
	private ErrorCodeEnum(String errorCode, String errorMessage) {
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}
	
}
