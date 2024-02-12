# Employee Management System

## Description

The Employee Management System is a Java Spring Boot application designed to manage employees within an organization. It provides functionalities to add, retrieve, update, and delete employee records, as well as sending email notifications for certain actions.

## Installation

To run the Employee Management System, you'll need:

- Java Development Kit (JDK) version 8 or higher
- Apache Maven
- MySQL or another compatible database

Follow these steps to set up the project:

```bash
# Clone the repository to your local machine:
git clone https://github.com/your/repository.git

# Navigate to the project directory:
cd employee-management-system

# Build the project using Maven:
mvn clean install
```
Update the database configuration in the application.properties file with your database credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
Run the application:
```bash
mvn clean spring-boot:run
```
## Usage

Once the application is running, you can interact with it using HTTP requests. Below are the available endpoints:

### Add Employee

To add an employee, send a POST request to the following endpoint:

POST /employees

### Get Employee by ID

To retrieve information about a specific employee, send a GET request to the following endpoint, replacing `{id}` with the employee's ID:

GET /employees/{id}

### Get All Employees

To retrieve a list of all employees, send a GET request to the following endpoint. You can paginate the results by providing optional query parameters:

GET /employees?page={pageNumber}&size={pageSize}&sort={sortBy}

### Update Employee by ID

To update information about a specific employee, send a PUT request to the following endpoint, replacing `{id}` with the employee's ID:

PUT /employees/{id}

### Delete Employee by ID

To delete a specific employee, send a DELETE request to the following endpoint, replacing `{id}` with the employee's ID:

DELETE /employees/{id}

### Get Nth Manager of an Employee

To retrieve the Nth manager of a specific employee, send a GET request to the following endpoint, replacing `{id}` with the employee's ID and `{n}` with the level of the manager:

GET /employees/{id}/manager?level={n}

Make sure to replace `{id}`, `{pageNumber}`, `{pageSize}`, `{sortBy}`, and `{n}` with the appropriate values when making requests.
## Contributing

Contributions to the Employee Management System are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add some feature'`).
5. Push to the branch (`git push origin feature/your-feature-name`).
6. Create a new Pull Request.

