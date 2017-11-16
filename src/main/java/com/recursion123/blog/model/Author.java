package com.recursion123.blog.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Author {
    private Integer id;
    private String name;
}
