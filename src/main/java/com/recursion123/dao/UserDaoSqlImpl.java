package com.recursion123.dao;

import com.recursion123.model.Department;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.sqlite.SQLiteConfig;

import java.util.List;

/**
 * Created by zhang on 2017/2/21.
 */
@Component
public class UserDaoSqlImpl implements UserDao {
    private final SqlSession sqlSession;

    public UserDaoSqlImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public List<User> listUser(User user) {
        return this.sqlSession.selectList("listUser", user);
    }

    @Override
    @Transactional
    public Integer insertUser(User user) {
        this.sqlSession.insert("insertUser", user);
        return this.sqlSession.insert("insertUserRoleMap", user);
    }

    @Override
    @Transactional
    public Integer deleteUser(User user) {
        this.sqlSession.delete("deleteUserRoleMap",user);
        return this.sqlSession.delete("deleteUser", user);
    }

    @Override
    @Transactional
    public Integer updateUser(User user) {
        this.sqlSession.delete("deleteUserRoleMap", user);
        this.sqlSession.insert("insertUserRoleMap", user);
        return this.sqlSession.update("updateUser", user);
    }

    @Override
    public Integer findUser(User user) {
        return this.sqlSession.selectOne("findUser", user);
    }

    @Override
    public User findUserByName(String name) {
        return this.sqlSession.selectOne("listUser", new User(name,null, null));
    }

    @Override
    public Integer insertRole(Role role) {
        return this.sqlSession.insert("insertRole",role);
    }

    @Override
    public Integer updateRole(Role role) {
        return this.sqlSession.update("updateRole",role);
    }

    @Override
    public List<Role> listRole(Role role) {
        return this.sqlSession.selectList("listRole",role);
    }

    @Override
    public Integer deleteRole(Role role) {
        return this.sqlSession.delete("deleteRole", role);
    }

    @Override
    public String getRoleName(Integer id) {
        return this.sqlSession.selectOne("getRoleName", id);
    }

    @Override
    public Integer insertDept(Department dept) {
        return this.sqlSession.insert("insertDept",dept);
    }

    @Override
    public Integer updateDept(Department dept) {
        return this.sqlSession.update("updateDept",dept);
    }

    @Override
    public List<Department> listDept(Department dept) {
        return this.sqlSession.selectList("listDept",dept);
    }

    @Override
    public Integer deleteDept(Department dept) {
        return this.sqlSession.delete("deleteDept",dept);
    }

    @Override
    public String getDeptName(Integer id) {
        return this.sqlSession.selectOne("getDeptName", id);
    }
}
