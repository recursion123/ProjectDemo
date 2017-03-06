package com.recursion123.controller;

import com.recursion123.model.User;
import com.recursion123.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/user/list")
    @ResponseBody
    public List<User> listUser(User user) {
        return userService.listUser(user);
    }

    @RequestMapping("/user/insert")
    @ResponseBody
    public Integer insertUser(User user) {
        return userService.insertUser(user);
    }

    @RequestMapping("/user/delete")
    @ResponseBody
    public Integer deleteUser(User user) {
        return userService.deleteUser(user);
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public Integer updateUser(User user, User condition) {
        return userService.updateUser(user, condition);
    }

    @RequestMapping("/login")
    @ResponseBody
    public Integer login(User user) {
        if (!StringUtils.isEmpty(user.getName())) {
            return userService.findUser(user);
        } else {
            return 0;
        }
    }
}
