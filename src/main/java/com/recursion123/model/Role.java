package com.recursion123.model;

import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
public enum Role {
    ADMIN("admin"), USER("user");

    private Role(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
