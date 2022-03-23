package org.daughter.base.dao.impl;

import org.daughter.base.dao.ArticleDAO;
import org.daughter.base.mapper.ArticleDAOMapper;
import org.daughter.base.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller("ArticleDAO")
public class ArticleDAOImplement implements  ArticleDAO{

    @Autowired
    private ArticleDAOMapper articleDAOMapper;

    public ArticleDAOImplement(){

    }
    @Override
    @Transactional
    public boolean articleIssue(Article article) {
        boolean b = articleDAOMapper.articleIssue( article );
        return b;
    }

    @Override
    @Transactional
    public List<Article> getArticles(Map<String,Integer> map) {
        List<Article> articles = articleDAOMapper.getArticles( map );
        return articles;
    }

    @Override
    public Article articleById(int articleId) {
        Article article = articleDAOMapper.articleById( articleId );
        return article;
    }

    @Override
    @Transactional
    public boolean articleDeleteById(int articleId) {
        boolean b = articleDAOMapper.articleDeleteById( articleId );
        return b;
    }

    @Override
    @Transactional
    public boolean articleUpdate(Article article) {
        boolean b = articleDAOMapper.articleUpdate( article );
        return b;
    }
}
