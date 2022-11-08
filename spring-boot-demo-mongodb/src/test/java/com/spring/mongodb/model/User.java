package com.spring.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user") //通过collection参数指定当前实体类对应的文档
public class User implements Serializable {
	@Id //用来标识主键
	private String id;

	private String name;

	@Field("pwd") //给字段起别名
	private String password;

	//@Indexed 用于声明字段需要索引

}
