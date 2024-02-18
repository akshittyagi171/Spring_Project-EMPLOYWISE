package com.employee_wise.assignment.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// TODO migrate to record

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeError {
	private String errorCode;
	private String errorMessage;
}