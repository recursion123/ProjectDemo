package com.recursion123.dao;

import com.recursion123.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Integer insertUser(User user) {
        this.sqlSession.insert("com.recursion123.model.User.insertUser", user);
        return this.sqlSession.insert("com.recursion123.model.User.insertUserRoleMap", user);
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
        List<User> userList = listUser(new User(userName, null, null));
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }
}
