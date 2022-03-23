package org.daughter.base.controller;

import org.daughter.base.dao.ArticleDAO;
import org.daughter.base.dao.SplitDAO;
import org.daughter.base.dao.sources.SplitPageBase;
import org.daughter.base.model.Article;
import org.daughter.base.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    @Qualifier("ArticleDAO")
    private ArticleDAO articleDAO;

    @Autowired
    @Qualifier("SplitDAO")
    private SplitDAO splitDAO;

    private String path;

    @RequestMapping("/issue")
    public String articleissueController(Article article, Model model, HttpSession session) {
        Users users = (Users) session.getAttribute( "users" );
        article.setUserId( users.getUserId() );
        boolean b = articleDAO.articleIssue( article );
        if(b){
            int articleId = article.getArticleId();
            article = articleDAO.articleById( articleId );
            model.addAttribute( "article"  , article);
            path = "article/article";
        }else{
            path = "users/login";
        }
        return path;
    }


    @RequestMapping("/get/{currentPage}")
    public String articleGetListController(@PathVariable("currentPage") int currentPage, Model model) {
        // 分页表名
        int size = SplitPageBase.size;
        // 分页表名
        String tableName = SplitPageBase.articleTableName;
        // 总函数
        int rows = splitDAO.allRows( tableName );
        // 总页数
        int totalPages = splitDAO.totalPage( rows, size );
        // 分页表开始行数
        int begin = splitDAO.currentRowsOfTheTable( currentPage, size );

        Map<String, Integer> map = new TreeMap<>();
        map.put( "begin", begin );
        map.put( "size", size );
        List<Article> articles = articleDAO.getArticles( map );
        model.addAttribute( "articles", articles );

        return path;
    }


    @RequestMapping("/byid/{articleId}")
    public String articleGetByIdController(@PathVariable("articleId") int articleId, Model model) {
        Article article = articleDAO.articleById( articleId );
        model.addAttribute( "article", article );
        return path;
    }

    @RequestMapping("/delete/{articleId}")
    public String articleDeleteByIdController(@PathVariable("articleId") int articleId) {
        boolean b = articleDAO.articleDeleteById( articleId );
        return path;
    }

    @RequestMapping("/update")
    public String articleUpdateController(Article article) {
        boolean b = articleDAO.articleUpdate( article );
        return path;
    }

}
