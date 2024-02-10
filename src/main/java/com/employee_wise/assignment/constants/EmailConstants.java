package com.employee_wise.assignment.constants;

import com.employee_wise.assignment.entity.Employee;

public class EmailConstants {
	
	public static String getMessage(String manName, Employee emp) {
		return "Hi "+manName+"\n\nA new Employee is Added under your supervision with Employee Details \n\n" + emp.getEmployeeName()+"\n"+emp.getPhoneNumber()+"\n"+emp.getEmail()+"\n\n Thanks and Regards";
	}
	
	public static String getSubject() {
		return "Regarding New Employee Addition";
	}
}
