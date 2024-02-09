package com.employee_wise.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
					title = "API Documentation",
					version = "1.0.0",
					description = "Documentation for all API in this project.",
					contact = @Contact(
								email = "tyagiakshit171@gmail.com",
								name = "Akshit Tyagi",
								url = "https://github.com/akshittyagi171"
							)
				)
)
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
