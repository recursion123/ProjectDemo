package com.recursion123.admin.dao;

import com.recursion123.admin.model.Department;
import com.recursion123.admin.model.Role;
import com.recursion123.admin.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author zhang
 * @date 2017/1/22
 */
@Component
public interface UserDao {
    List<User> listUser(User user);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user);

    Integer updateUserPassword(User user);

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
