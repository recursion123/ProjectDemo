package com.recursion123.admin.model;


import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhang on 2017/1/22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User implements Serializable {
    private Integer id;

    private String name;
    private String password;
    private Department dept;
    private List<Integer> role;
}


