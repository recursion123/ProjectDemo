package com.recursion123.blog.service.impl;

import com.recursion123.blog.dao.ArticleDao;
import com.recursion123.blog.model.Article;
import com.recursion123.blog.model.ArticleTag;
import com.recursion123.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> listArticle(Article article) {
        return articleDao.listArticle(article);
    }

    @Override
    public Article findArticleByID(String id) {
        return articleDao.findArticleByID(id);
    }

    @Override
    public Integer insertArticle(Article article) {
        return articleDao.insertArticle(article);
    }

    @Override
    public Integer deleteArticle(Article article) {
        return articleDao.deleteArticle(article);
    }

    @Override
    public Integer updateArticle(Article article) {
        return articleDao.updateArticle(article);
    }

    @Override
    public List<ArticleTag> listArticleTag() {
        return articleDao.listArticleTag();
    }

    @Override
    public Integer insertArticleTag(ArticleTag articleTag) {
        return articleDao.insertArticleTag(articleTag);
    }

    @Override
    public Integer deleteArticleTag(ArticleTag articleTag) {
        return articleDao.deleteArticleTag(articleTag);
    }

    @Override
    public Integer updateArticleTag(ArticleTag articleTag) {
        return articleDao.updateArticleTag(articleTag);
    }
}
