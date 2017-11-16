package com.recursion123.admin.model;

import lombok.*;

import java.io.Serializable;

/**
 * Created by zhang on 2017/1/22.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Role implements Serializable {
    private Integer id;
    private String name;
}
