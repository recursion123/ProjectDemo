package com.recursion123.dao;

import com.recursion123.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

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
        return this.sqlSession.selectList("com.recursion123.model.User.listUser", user);
    }

    @Override
    public Integer insertUser(User user) {
        return this.sqlSession.insert("com.recursion123.model.User.insertUser", user);
    }

    @Override
    public Integer deleteUser(User user) {
        return this.sqlSession.delete("com.recursion123.model.User.deleteUser", user);
    }

    @Override
    public Integer updateUser(User user, User condition) {
        return this.sqlSession.update("com.recursion123.model.User.deleteUser", user);
    }

    @Override
    public Integer findUser(User user) {
        return this.sqlSession.selectOne("com.recursion123.model.User.findUser", user);
    }

    @Override
    public User findUserByName(String userName) {
        return this.sqlSession.selectOne("com.recursion123.model.User.findUserByName", userName);
    }

}
