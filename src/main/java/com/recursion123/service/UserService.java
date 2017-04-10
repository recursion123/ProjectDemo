package com.recursion123.service;

import com.recursion123.dao.UserDao;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> listUser(User user) {
        return userDao.listUser(user);
    }

    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    public Integer deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    public Integer updateUser(User user, User condition) {
        return userDao.updateUser(user, condition);
    }

    public Integer findUser(User user) {
        return userDao.findUser(user);
    }

    public List<Role> listRole(Role role) {
        return userDao.listRole(role);
    }

    public Integer insertRole(Role role) {
        return userDao.insertRole(role);
    }

    public Integer updateRole(Role role) {
        return userDao.updateRole(role);
    }
}
