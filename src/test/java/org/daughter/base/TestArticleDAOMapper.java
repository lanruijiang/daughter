package org.daughter.base;

import org.daughter.base.mapper.ArticleDAOMapper;
import org.daughter.base.model.Article;
import org.daughter.base.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestArticleDAOMapper {

    @Autowired(required = false)
    private ArticleDAOMapper articleDAOMapper;

    @Test
    public void testGetArticles(){
        Map<String,Integer> map = new TreeMap<>();
        map.put( "begin"  , 0);
        map.put( "size"  , 5);
      List<Article> articles =  articleDAOMapper.getArticles(map);
        for(Article article : articles){
            Users users = article.getUsers();
            System.out.println(article.getUsers().getUserId());
            System.out.println(article.getUsers().getUserName());
        }
    }

}
