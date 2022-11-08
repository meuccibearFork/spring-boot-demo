package com.spring.mongodb.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import com.spring.mongodb.model.Employee;
import com.spring.mongodb.repository.EmployeeRepository;
import com.spring.mongodb.service.EmployeeService;
import javax.annotation.Resource;

/**
 * 员工接口实现类
 * 第一种方式，直接继承xxxRepository接口，其最终将会继承Repository标记接口，我们可以不必自己写实现类，轻松实现增删改查、分页、排序操作，但是对于比较复杂的查询，使用起来就比较费力。
 * 第二种方式，直接使用xxxTemplate，这需要自己写实现类，但是这样增删改查可以自己控制，对于复杂查询，用起来得心应手。
 *
 * @author zrj
 * @since 2022/3/29
 **/
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	private EmployeeRepository employeeRepository;
//	EmployeeRepository employeeRepository;
	@Resource
	private MongoTemplate mongoTemplate;

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByLastName(String lastName) {

		List<Employee> employees = employeeRepository.findAll();

		for (Employee emp : employees) {
			if (emp.getLastName().equalsIgnoreCase(lastName))
				return emp;
		}
		return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public Employee getEmployeeById(int empId) {
		List<Employee> employees = employeeRepository.findAll();
		for (Employee emp : employees) {
			if (empId == emp.getEmpId())
				return emp;
		}
		return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		List<Employee> employees = new ArrayList<>();
		List<Employee> list = employeeRepository.findAll();
		for (Employee emp : list) {
			if (emp.getFirstName().equalsIgnoreCase(firstName))
				employees.add(emp);
		}
		return employees;
	}

	@Override
	public Employee getOneEmployeeByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> getEmployeeByFirstNameLike(String firstName) {
		return employeeRepository.findByFirstNameLike(firstName);
	}

//	@Override
//	public Employee getEmployeeByFirstName(Employee employee) {
//		List<Employee> list = employeeRepository.findAll();
//		for (Employee emp : list) {
//			if (emp.getFirstName().equals(employee.getFirstName()))
//				return emp;
//		}
//		return Employee.builder().empId(0).firstName("Not Found").lastName("Please enter valid id").salary(0f).build();
//	}
//
//	@Override
//	public List<Employee> getEmployeeByFrName(Employee employee) {
//		List<Employee> employees = new ArrayList<>();
//
//		if (null != employee && null != employee.getFirstName()
//				&& !(employee.getFirstName().equals(""))) {
//			List<Employee> list = employeeRepository.findAll();
//
//			for (Employee emp : list) {
//				if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
//					employees.add(emp);
//				}
//			}
//		}
//		return employees;
//	}

	@Override
	public List<Employee> getEmployeeBySalaryGreaterThan(int salary) {
		List<Employee> employees = new ArrayList<>();

		if (salary > 0) {
			List<Employee> list = employeeRepository.findAll();

			for (Employee emp : list) {
				if (emp.getSalary() > salary)
					employees.add(emp);
			}
		}
		return employees;
	}




	@Override
	public List<Employee> getEmployeeByCondition(Employee employee) {
		List<Employee> list = employeeRepository.findAll();
		List<Employee> employees = new ArrayList<>();

		// This will return true if employee object is present(not null) any one of
		// property is not null OR greater than 0
		if (null != employee && (null != employee.getFirstName() || employee.getEmpId() > 0
				|| null != employee.getLastName() || employee.getSalary() > 0)) {

			for (Employee emp : list) {

				// If all 4 properties are present then only this block will execute
				if (null != employee.getFirstName() && employee.getEmpId() > 0 && null != employee.getLastName()
						&& employee.getSalary() > 0) {

					if (emp.getEmpId() == employee.getEmpId()
							&& emp.getFirstName().equalsIgnoreCase(employee.getFirstName())
							&& emp.getLastName().equalsIgnoreCase(employee.getLastName())
							&& emp.getSalary() == employee.getSalary()) {
						employees.add(emp);
						// Break the for loop
						break;
					} else {
						// Go back to first statement
						continue;
					}
				}

				// if any one of above property is null or less than equals to 0 then below
				// block is executing
				// Emp Id
				if (employee.getEmpId() == emp.getEmpId()) {
					employees.add(emp);
					// Go back to first statement
					continue;
				}

				// First name
				if (null != employee.getFirstName()) {
					if (emp.getFirstName().toLowerCase().contains(employee.getFirstName().toLowerCase())) {
						employees.add(emp);
						// Go back to first statement
						continue;
					}
				}

				// Last name
				if (null != employee.getLastName()) {
					if (emp.getLastName().equalsIgnoreCase(employee.getLastName()))
						employees.add(emp);
					// Go back to first statement
					continue;
				}
				// salary
				if (employee.getSalary() == emp.getSalary()) {
					employees.add(emp);
				}
				// ---------------------------------------------------------
			}
			// returning the list
			return employees;
		}
		// if below statements return false only then below list is returning
		// if (null != employee &&
		// (null != employee.getFirstName() || employee.getEmpId() > 0
		// || null != employee.getLastName() || employee.getSalary() > 0))
		return employees;
	}

}
