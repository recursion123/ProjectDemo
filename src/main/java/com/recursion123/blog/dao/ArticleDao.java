package com.recursion123.blog.dao;

import com.recursion123.blog.model.Article;

import java.util.List;

public interface ArticleDao {
    List<Article> listArticle(Article article);

    Integer insertArticle(Article article);

    Integer deleteArticle(Article article);
}
