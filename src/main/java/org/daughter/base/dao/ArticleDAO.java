package org.daughter.base.dao;

import java.util.List;
import java.util.Map;

import org.daughter.base.model.Article;

public interface ArticleDAO {
	/**
	 * 发布文章
	 * @param article
	 * @return
	 */
	public boolean articleIssue(Article article);
	
	/**
	 * 每页文章的信息
	 * @param map : begin size
	 * @return
	 */
	public List<Article> getArticles(Map<String,Integer> map);
	
	/**
	 * 指定ID的文章详细信息
	 * @param articleId
	 * @return
	 */
	public Article articleById(int articleId);
	
	/**
	 * 删除文章
	 * @param articleId
	 * @return
	 */
	public boolean articleDeleteById(int articleId);
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	public boolean articleUpdate(Article article);
}
