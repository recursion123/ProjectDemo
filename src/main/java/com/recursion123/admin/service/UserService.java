package com.recursion123.admin.service;

import com.recursion123.admin.model.Department;
import com.recursion123.admin.model.Role;
import com.recursion123.admin.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhang on 2017/6/29.
 */
@Service
public interface UserService {
    List<User> listUser(User user);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);

    Integer updateUserPassword(User oldUser, User newUser);

    Integer findUser(User user);

    List<Role> listRole(Role role);

    Integer insertRole(Role role);

    Integer updateRole(Role role);

    Integer deleteRole(Role role);

    List<Department> listDept(Department dept);

    Integer deleteDept(Department dept);

    Integer insertDept(Department dept);

    Integer updateDept(Department dept);
}
