package com.spring.mongodb.service;

import com.spring.mongodb.model.User;
import java.util.List;

/**
 * @author zrj
 * @since 2022/3/29
 **/
public interface UserService {
    /**
     * 新增
     * @return String
     */
    String create();

    /**
     * 更新
     * @return String
     */
    String update();

    /**
     * 删除
     * @return String
     */
    String delete();

    /**
     * 查询
     * @return String
     */
    List<User> select();

}

