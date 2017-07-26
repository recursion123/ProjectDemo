package com.recursion123.service;

import com.recursion123.dao.UserDao;
import com.recursion123.model.Department;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
@Service
@javax.jws.WebService(serviceName = "UserService", portName = "UserPort",
        targetNamespace = "http://service.ws.sample/",
        endpointInterface = "com.recursion123.service.UserService")
public class UserServiceImpl implements UserService {
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

    public Integer updateUser(User user) {
        return userDao.updateUser(user);
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
