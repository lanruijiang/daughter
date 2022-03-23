package org.daughter.base.dao;

import java.util.List;
import java.util.Map;

import org.daughter.base.model.Reply;

public interface ReplyDAO {

	/**
	 * 发布评论
	 * @param reply
	 * @return
	 */
	public boolean replyIssue(Reply reply);
	
	/**
	 * 查看评论
	 * @param  map : begin size articleId
	 * @return
	 */
	public List<Reply> getReplies(Map<String,Integer> map);
	
	/**
	 * 删除评论
	 * @param replyId
	 * @return
	 */
	public boolean replyDelete(int replyId);
	
}
