package org.daughter.base.mapper;

import org.apache.ibatis.annotations.*;
import org.daughter.base.model.Users;

@Mapper
public interface UserDAOMapper {

	/**
	 * 注册
	 * @param users
	 * @return
	 */
	@Insert( "insert into users (userName,userPassword,userEmail,userDescribe,userLoginTime) " +
			"values (#{userName},#{userPassword},#{userEmail},#{userDescribe},now())" )
	public boolean userRegist(Users users);
	
	/**
	 * 登录
	 * @param users
	 * @return
	 */
	@Select( "select * from users where userEmail = #{userEmail} and userPassword = #{userPassword}" )
	public Users userLogin(Users users);
	
	/**
	 * 修改
	 * @param users
	 * @return
	 */
	@UpdateProvider(type = UsersOperationDynamicSql.class , method = "userUpdateDynamicSQL")
	public boolean userUpdate(Users users);

	/**
	 * 创建头像
	 * @param userHead
	 * @return
	 */
	@Update( "update users set userHead = #{userHead} where userId = #{userId}" )
	public boolean userHeadCreate(Users users);

	/**
	 * ID查询用户信息
	 * @param userId
	 * @return
	 */
	@ConstructorArgs({
			@Arg( id = true , column = "userId" , javaType = Integer.class),
			@Arg(column = "userName" , javaType = String.class)
	})
	@Select("select userId,userName from users where userId = #{userId}")
	public Users getUserById(int userId);

	@Select( "select * from users where userId = #{userId}" )
	public Users getUsesDetailById(int userId);

}
