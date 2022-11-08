package com.spring.mongodb.service.impl;

import cn.hutool.core.util.IdUtil;
import com.spring.mongodb.model.User;
import com.spring.mongodb.repository.UserRepository;
import com.spring.mongodb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

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
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
//    UserRepository
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 新增
     *
     * @return String
     */
    @Override
    public String create() {
        //第一种方式，直接继承xxxRepository接口
        User user = User.builder().id("1").name("张三").password("123").build();
        userRepository.save(user);
        log.info("第一种方式新增成功，employee：" + user);

        //第二种方式，直接使用xxxTemplate
        //注意：id不能重复。MongoWriteException: E11000 duplicate key error collection: mongo.employee index: _id_ dup key: { _id: "3" }
        User user2 = User.builder().id(IdUtil.simpleUUID()).name("李四").password("123").build();
        mongoTemplate.insert(user2);
        log.info("第二种方式新增成功，employee：" + user2);

        log.info("【员工接口】新增成功");
        return "新增成功";
    }

    /**
     * 更新
     *
     * @return String
     */
    @Override
    public String update() {
        //第一种方式，直接继承xxxRepository接口
        User user = User.builder().id("1").name("张更新").password("666").build();
        userRepository.save(user);

        //第二种方式，直接使用xxxTemplate
        Query query = Query.query(Criteria.where("id").is("2").and("name").is("王小二"));
        Update update = Update.update("name", "王更新");
        mongoTemplate.updateFirst(query, update, User.class);

        log.info("【员工接口】更新成功");
        return "更新成功";
    }

    /**
     * 删除
     *
     * @return String
     */
    @Override
    public String delete() {
        //第一种方式，直接继承xxxRepository接口
        userRepository.deleteById("1");

        //第二种方式，直接使用xxxTemplate
        Query query = Query.query(Criteria.where("id").is("2"));
        mongoTemplate.remove(query, User.class);

        log.info("【员工接口】删除成功");
        return "删除成功";
    }

    /**
     * 查询
     *
     * @return String
     */
    @Override
    public List<User> select() {
        //第一种方式，直接继承xxxRepository接口
        List<User> employeeList = userRepository.findAll();
        System.out.println("第一种方式，employeeList：" + employeeList);

        //第二种方式，直接使用xxxTemplate
        List<User> employeeLists = this.mongoTemplate.findAll(User.class);
        System.out.println("第二种方式，employeeList：" + employeeLists);

        log.info("【员工接口】查询成功");
        return employeeLists;
    }
}

