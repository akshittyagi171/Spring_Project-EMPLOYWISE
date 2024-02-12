package com.employee_wise.assignment.constants;

import com.employee_wise.assignment.entity.Employee;

public class EmailConstants {
	
	public static String getAdditionMessage(String manName, Employee emp) {
		return "Hi "+manName+"\n\nA new Employee is Added under your supervision with Employee Details \n\n" + emp.getEmployeeName()+"\n"+emp.getPhoneNumber()+"\n"+emp.getEmail()+"\n\n Thanks and Regards";
	}
	
	public static String getAdditionSubject() {
		return "Regarding New Employee Addition";
	}
	
	public static String getDeletionMessage(String manName, Employee emp) {
		return "Hi "+manName+"\n\nEmployee is deleted under your supervision with Employee Details \n\n" + emp.getEmployeeName()+"\n"+emp.getPhoneNumber()+"\n"+emp.getEmail()+"\n\n Thanks and Regards";
	}
	
	public static String getDeletionSubject() {
		return "Regarding Employee Deletion";
	}
	
	public static String getUpdationMessage(String manName, Employee emp) {
		return "Hi "+manName+"\n\nEmployee Details have been Updated / or has come under your supervision with Employee Details \n\n" + emp.getEmployeeName()+"\n"+emp.getPhoneNumber()+"\n"+emp.getEmail()+"\n\n Thanks and Regards";
	}
	
	public static String getUpdationSubject() {
		return "Regarding Employee Details Updation";
	}
}
