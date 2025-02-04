package com.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.model.Employee;

import java.util.List;
/**
 * 员工Dao
 * 定义Dao接口继承MongoRepository<实体类型,主键类型>
 *
 * @author zrj
 * @since 2022/3/29
 **/
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findByFirstName(String firstName);

    List<Employee> findByFirstNameLike(String firstName);


}
