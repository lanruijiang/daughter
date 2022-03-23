package org.daughter.base.dao;

import org.daughter.base.model.Users;

public interface UserDAO {

	/**
	 * 注册
	 * @param users
	 * @return
	 */
	public boolean userRegist(Users users);
	
	/**
	 * 登录
	 * @param users
	 * @return
	 */
	public Users userLogin(Users users);
	
	/**
	 * 修改
	 * @param users
	 * @return
	 */
	public boolean userUpdate(Users users);

	/**
	 * 创建头像
	 *
	 * @param users
	 * @return
	 */
	public boolean userHeadCreate(Users users) ;

	/**
	 * 查询用户详细信息
	 * @param userId
	 * @return
	 */
	public Users getUsesDetailById(int userId);
}