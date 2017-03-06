package com.recursion123.dao;

import com.recursion123.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/1/22.
 */
public interface UserDao {
    List<User> listUser(User user);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user,User condition);

    Integer findUser(User user);

    User findUserByName(String username);
}