package com.recursion123.service;

import com.recursion123.dao.UserDao;
import com.recursion123.model.Role;
import com.recursion123.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhang on 2017/1/18.
 * UserDetailsService实现，用于用户验证
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findUserByName(username);
        if (user == null) {
            System.err.println("user not found with the provided username:" + username);
            return null;
        }
        System.err.println("user from username " + user.toString());
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthorities(user));
    }

    private Set<GrantedAuthority> getAuthorities(User user) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().getName());
        authorities.add(grantedAuthority);
        System.err.println("user authorities are " + authorities.toString());
        return authorities;
    }

}
