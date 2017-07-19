package com.recursion123.model;


import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private List<Integer> role;

    public User() {
    }

    public User(String name, String password, List<Integer> role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getRole() {
        return role;
    }

    public void setRole(List<Integer> role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}


