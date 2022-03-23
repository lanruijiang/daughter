package org.daughter.base.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.daughter.base.model.Reply;
import org.daughter.base.model.Users;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReplyDAOMapper {

	/**
	 * 发布评论
	 * @param reply
	 * @return
	 */
	@Insert( "insert into reply(replyContent,replyTime,replyAuthorId,authorId,articleId) " +
			"values (#{replyContent},now(),#{replyAuthorId},#{authorId},#{articleId})" )
	public boolean replyIssue(Reply reply);
	
	/**
	 * 查看评论
	 * @param begin
	 * @param size
	 * @param articleId
	 * @return
	 */
	@Results(value = {
			@Result(id = true , property = "replyId" , column = "replyId"),
			@Result(property = "replyAuthor" , column = "replyAuthorId" , javaType = Users.class ,
					one = @One(select = "org.daughter.base.mapper.UserDAOMapper.getUserById" , fetchType = FetchType.DEFAULT))
	})
	@Select( "select * from article " +
			"where articleId = #{articleId} order by replyTime limit #{begin},#{size} " )
	public List<Reply> getReplies(Map<String,Integer> map);
	
	/**
	 * 删除评论
	 * @param replyId
	 * @return
	 */
	@Delete( "delete from reply where replyId = #{replyId}" )
	public boolean replyDelete(int replyId);
	
}
