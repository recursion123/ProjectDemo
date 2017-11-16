package com.recursion123.blog.controller;

import com.recursion123.blog.model.Article;
import com.recursion123.blog.model.ArticleTag;
import com.recursion123.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping("/blog/listArticle")
    @ResponseBody
    List<Article> listArticle(@RequestBody Article article) {
        return articleService.listArticle(article);
    }

    @RequestMapping("/blog/findArticleByID")
    @ResponseBody
    Article findArticleByID(String id) {
        return articleService.findArticleByID(id);
    }

    @RequestMapping("/admin/insertArticle")
    @ResponseBody
    Integer insertArticle(@RequestBody Article article) {
        return articleService.insertArticle(article);
    }

    @RequestMapping("/admin/deleteArticle")
    @ResponseBody
    Integer deleteArticle(@RequestBody Article article) {
        return articleService.deleteArticle(article);
    }

    @RequestMapping("/admin/updateArticle")
    @ResponseBody
    Integer updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

    @RequestMapping("/blog/listArticleTag")
    @ResponseBody
    List<ArticleTag> listArticleTag() {
        return articleService.listArticleTag();
    }

    @RequestMapping("/admin/insertArticleTag")
    @ResponseBody
    Integer insertArticleTag(@RequestBody ArticleTag articleTag) {
        return articleService.insertArticleTag(articleTag);
    }
}

