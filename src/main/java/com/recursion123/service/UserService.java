package com.recursion123.service;

import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by zhang on 2017/6/29.
 */
@Service
@WebService(targetNamespace = "http://service.ws.sample/", name = "User")
public interface UserService {
    List<User> listUser(User user);

    Integer insertUser(User user);

    Integer deleteUser(User user);

    Integer updateUser(User user, User condition);

    Integer findUser(User user);

    List<Role> listRole(Role role);

    Integer insertRole(Role role);

    Integer updateRole(Role role);

    String sayHi(String str);
}
