package com.recursion123.blog.dao.impl;

import com.recursion123.blog.dao.ArticleDao;
import com.recursion123.blog.model.Article;
import com.recursion123.blog.model.ArticleTag;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ArticleDaoImpl implements ArticleDao {
    private final SqlSession sqlSession;

    public ArticleDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Article> listArticle(Article article) {
        return sqlSession.selectList("listArticle", article);
    }

    @Override
    public Article findArticleByID(String id) {
        return sqlSession.selectOne("findArticleByID", id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertArticle(Article article) {
        sqlSession.insert("insertArticle", article);
        return sqlSession.insert("insertArticleTagMap", article);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteArticle(Article article) {
        for (ArticleTag articleTag : article.getTags()) {
            sqlSession.delete("deleteArticleTag", articleTag);
        }
        sqlSession.delete("deleteArticleTagMap", article);
        return sqlSession.delete("deleteArticle", article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateArticle(Article article) {
        sqlSession.delete("deleteArticleTagMap", article);
        sqlSession.insert("insertArticleTagMap", article);
        return sqlSession.update("updateArticle", article);
    }

    @Override
    public List<ArticleTag> listArticleTag() {
        return sqlSession.selectList("listArticleTag");
    }

    @Override
    public Integer insertArticleTag(ArticleTag articleTag) {
        sqlSession.insert("insertArticleTag", articleTag);
        return articleTag.getId();
    }

    @Override
    public Integer deleteArticleTag(ArticleTag articleTag) {
        return sqlSession.delete("deleteArticleTag", articleTag);
    }

    @Override
    public Integer updateArticleTag(ArticleTag articleTag) {
        return sqlSession.update("updateArticleTag", articleTag);
    }
}
