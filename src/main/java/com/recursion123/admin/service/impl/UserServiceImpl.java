package com.recursion123.admin.service.impl;

import com.recursion123.admin.dao.UserDao;
import com.recursion123.admin.model.Department;
import com.recursion123.admin.model.Role;
import com.recursion123.admin.model.User;
import com.recursion123.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> listUser(User user) {
        return userDao.listUser(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Integer deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public Integer updateUserPassword(User oldUser, User newUser) {
        Integer userNum=userDao.findUser(oldUser);
        if(userNum==1){
            return userDao.updateUser(newUser);
        }
        return userNum;
    }

    @Override
    public Integer findUser(User user) {
        return userDao.findUser(user);
    }

    @Override
    public List<Role> listRole(Role role) {
        return userDao.listRole(role);
    }

    @Override
    public Integer insertRole(Role role) {
        return userDao.insertRole(role);
    }

    @Override
    public Integer updateRole(Role role) {
        return userDao.updateRole(role);
    }

    @Override
    public Integer deleteRole(Role role) {
        return userDao.deleteRole(role);
    }

    @Override
    public List<Department> listDept(Department dept) {
        return userDao.listDept(dept);
    }

    @Override
    public Integer deleteDept(Department dept) {
        return userDao.deleteDept(dept);
    }

    @Override
    public Integer insertDept(Department dept) {
        return userDao.insertDept(dept);
    }

    @Override
    public Integer updateDept(Department dept) {
        return userDao.updateDept(dept);
    }
}
