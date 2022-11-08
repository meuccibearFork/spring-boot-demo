package com.spring.mongodb.repository;

import com.spring.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 员工Dao
 * 定义Dao接口继承MongoRepository<实体类型,主键类型>
 *
 * @author zrj
 * @since 2022/3/29
 **/
public interface UserRepository extends MongoRepository<User, String> {

//    User findByFirstName(String firstName);
//
//    List<User> findByFirstNameLike(String firstName);


}
