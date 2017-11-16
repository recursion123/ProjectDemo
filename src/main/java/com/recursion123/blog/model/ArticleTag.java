package com.recursion123.blog.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ArticleTag {
    private Integer id;
    private String name;
    private String type;
}
