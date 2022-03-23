package org.daughter.base.controller;

import org.daughter.base.dao.ReplyDAO;
import org.daughter.base.dao.SplitDAO;
import org.daughter.base.dao.sources.SplitPageBase;
import org.daughter.base.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("reply")
public class ReplyController {
    @Autowired
    @Qualifier("ReplyDAO")
    private ReplyDAO replyDAO;

    @Autowired
    @Qualifier("SplitDAO")
    public SplitDAO splitDAO;

    // 分页表名
   private int size = SplitPageBase.replySize;
    // 分页表名
   private String tableName = SplitPageBase.replyTableName;

    /**
     * 发布回复信息
     *
     * @param reply
     * @return
     */
    @RequestMapping("/issue")
    public boolean replyIssueController(Reply reply) {
        boolean b = replyDAO.replyIssue( reply );
        return b;
    }

    @RequestMapping("/get/{currentPage}/{articleId}")
    public Map<String,Object> getRepliesController(@PathVariable("currentPage") int currentPage,
                                            @PathVariable("articleId") int articleId) {
        // 总函数
        int rows = splitDAO.allRows( tableName );
        // 总页数
        int totalPages = splitDAO.totalPage( rows, size );


        List<Reply> replies = getReplyCurrentPageInfo( currentPage,articleId,size,tableName,rows );
        Map<String,Object> map = new TreeMap<>();
        map.put( "replies" , replies);
        map.put( "totalPages" , totalPages);
        map.put( "currentPage",currentPage );
        return  map;
    }

    @RequestMapping("/delete/{replyId}/{currentPage}/{articleId}")
    public Map<String,Object> replydeleteController(@PathVariable("replyId") int replyId ,
                                      @PathVariable("currentPage") int currentPage,
                                      @PathVariable("articleId") int articleId) {
        boolean b = replyDAO.replyDelete( replyId );
        // 总函数
        int rows = splitDAO.allRows( tableName );
        // 总页数
        int totalPages = splitDAO.totalPage( rows, size );

        List<Reply> replies = getReplyCurrentPageInfo( currentPage,articleId,size,tableName,rows );
        Map<String,Object> map = new TreeMap<>();
        map.put( "replies" , replies);
        map.put( "totalPages" , totalPages);
        map.put( "currentPage",currentPage );
        return  map;
    }

    /**
     * 查询指定页数的回复信息
     * @param currentPage
     * @param articleId
     * @param size
     * @param tableName
     * @param rows
     * @return
     */
    public List<Reply> getReplyCurrentPageInfo(int currentPage , int articleId , int size , String tableName , int rows){

        // 分页表开始行数
        int begin = splitDAO.currentRowsOfTheTable( currentPage, size );

        Map<String, Integer> map = new TreeMap<>();
        map.put( "begin", begin );
        map.put( "size", size );
        map.put( "articleId", articleId );

        List<Reply> replies = replyDAO.getReplies( map );
        return replies;
    }

}
