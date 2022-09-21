package com.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.model.Employee;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstName);

    List<Employee> findByFirstNameLike(String firstName);


}
