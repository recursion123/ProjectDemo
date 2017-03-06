package com.recursion123.dao;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.recursion123.model.User;
import com.recursion123.util.MongoUtil;
import org.jongo.MongoCollection;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang on 2017/1/22.
 */
//@Component
public class UserDaoMongoImpl implements UserDao {
    MongoCollection mongoCollection = MongoUtil.COLLECTIONS.getCollection("user");
    Gson gson = new Gson();

    @Override
    public List<User> listUser(User user) {
        List<User> list = new ArrayList<>();
        for (User resUser : mongoCollection.find(gson.toJson(user)).as(User.class)) {
            list.add(resUser);
        }
        return list;
    }

    @Override
    public Integer insertUser(User user) {
        return mongoCollection.insert(user).getN();
    }

    @Override
    public Integer deleteUser(User user) {
        return mongoCollection.remove(gson.toJson(user)).getN();
    }

    @Override
    public Integer updateUser(User user, User condition) {
        return mongoCollection.update(gson.toJson(condition)).with(user).getN();
    }

    @Override
    public Integer findUser(User user) {
        return Math.toIntExact(mongoCollection.count(gson.toJson(user)));
    }

    @Override
    public User findUserByName(String username) {
        return mongoCollection.findOne("{name:'" + username + "'}").as(User.class);
    }
}
