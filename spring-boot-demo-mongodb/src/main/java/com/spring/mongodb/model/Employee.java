package com.spring.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "employee") //通过collection参数指定当前实体类对应的文档
public class Employee implements Serializable {

	@Id //用来标识主键
	private String id;

//	@Field("pwd") //给字段起别名
//	private String password;

	//@Indexed 用于声明字段需要索引

	private int empId;
	private String firstName;
	private String lastName;
	private float salary;

}
