package org.daughter.base.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * create table reply ( replyId int primary key auto_increment, replyContent
 * text, replyTime timestamp, replyAuthorId int, authorId int, articleId int );
 */
@Data
@AllArgsConstructor
public class Reply {
	private int replyId;
	private String replyContent;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date replyTime;
	private int replyAuthorId;
	private int authorId;
	private int articleId;
	private Users replyAuthor;
}
