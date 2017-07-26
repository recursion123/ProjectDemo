package com.recursion123.dao;

import com.recursion123.model.Department;
import com.recursion123.model.Role;
import com.recursion123.model.User;

import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
public interface UserDao {
    List<User> listUser(User user);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);

    Integer findUser(User user);

    User findUserByName(String username);

    Integer insertRole(Role role);

    Integer updateRole(Role role);

    List<Role> listRole(Role role);

    Integer deleteRole(Role role);

    String getRoleName(Integer id);

    Integer insertDept(Department dept);

    Integer updateDept(Department dept);

    List<Department> listDept(Department dept);

    Integer deleteDept(Department dept);

    String getDeptName(Integer id);
}
