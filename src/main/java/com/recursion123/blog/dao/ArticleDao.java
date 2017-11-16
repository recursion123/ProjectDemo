package com.recursion123.blog.dao;

import com.recursion123.blog.model.Article;
import com.recursion123.blog.model.ArticleTag;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleDao {
    List<Article> listArticle(Article article);

    Article findArticleByID(String id);

    Integer insertArticle(Article article);

    Integer deleteArticle(Article article);

    Integer updateArticle(Article article);

    List<ArticleTag> listArticleTag();

    Integer insertArticleTag(ArticleTag articleTag);

    Integer deleteArticleTag(ArticleTag articleTag);

    Integer updateArticleTag(ArticleTag articleTag);
}
