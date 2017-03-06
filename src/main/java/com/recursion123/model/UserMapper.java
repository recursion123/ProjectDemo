package com.recursion123.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper{
    @Select("select * from user_tbl")
    List<User> listUser(User user);

    boolean addUser(User user);

    boolean deleteUser(User user);

    boolean updateUser(User user,User condition);

    boolean findUser(User user);

    User findUserByName(String username);

}
