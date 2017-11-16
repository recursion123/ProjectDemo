package com.recursion123.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Author author;
    private String updateTime;
    private List<ArticleTag> tags;
}
