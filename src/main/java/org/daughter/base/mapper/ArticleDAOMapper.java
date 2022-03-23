package org.daughter.base.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.daughter.base.model.Article;
import org.daughter.base.model.Users;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleDAOMapper {
    /**
     * 发布文章
     *
     * @param article
     * @return
     */
    @Insert("insert into article (articleTitle,articleContent,articleTime,articleDescribe,userId) value (#{articleTitle},#{articleContent},now(),#{articleDescribe},#{userId})")
   @Options(keyProperty = "articleId" , keyColumn = "articleId" , useGeneratedKeys = true)
    public boolean articleIssue(Article article);

    /**
     * 每页文章的信息
     *
     * @param begin
     * @param size
     * @return
     */
    @Results(value = {
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "users", column = "userId", javaType = Users.class,
                    one = @One(select = "org.daughter.base.mapper.UserDAOMapper.getUserById", fetchType = FetchType.EAGER))
    })
    @Select( "select * from article  order by  articleTime desc limit #{begin},#{size}" )
    public List<Article> getArticles(Map<String,Integer> map);





    /**
     * 指定ID的文章详细信息
     *
     * @param articleId
     * @return
     */
    @Results(value = {
            @Result(id = true, property = "articleId", column = "articleId"),
            @Result(property = "users", column = "userId", javaType = Users.class,
                    one = @One(select = "org.daughter.base.mapper.UserDAOMapper.getUserById", fetchType = FetchType.EAGER))
    })
    @Select( "select * from article where articleId = #{articleId}")
    public Article articleById(int articleId);

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @Delete( "delete from article where articleId = #{articleId}" )
    public boolean articleDeleteById(int articleId);

    /**
     * 修改文章
     *
     * @param article
     * @return
     */
    @Update( "update article set articleTitle = #{articleTitle} , articleContent = #{articleContent} , articleTime = now() where articleId = #{articleId}" )
    public boolean articleUpdate(Article article);
}
