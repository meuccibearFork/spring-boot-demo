package com.spring.mongodb.service;

import java.util.List;

import com.spring.mongodb.model.Employee;

public interface EmployeeQueryService {

	List<Employee> getAll();

	List<Employee> getEmployeeByFirstName(String firstName);

	Employee getSingleEmployeeByLastName(String lastName);

	List<Employee> getEmployeeByFirstNameLike(String firstName);

	Employee getOneEmployeeByFirstName(String firstName);

	List<Employee> getEmployeeBySalaryGreaterThan(int salary);

	List<Employee> getEmployeeByCondition(Employee employee);


}
