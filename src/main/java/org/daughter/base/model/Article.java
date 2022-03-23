package org.daughter.base.model;

import lombok.*;

import java.util.Date;

/**
 * create table article ( articleId int primary key auto_increment, articleTitle
 * varchar(200), articleContent text, articleTime timestamp, userId int );
 */



//@Setter
//@Getter
//@NoArgsConstructor
@Data
public class Article {
	private int articleId;
	private String articleTitle;
	private String articleContent;
	private Date articleTime;
	private int userId;
	private String articleDescribe;
	private Users users;


}
