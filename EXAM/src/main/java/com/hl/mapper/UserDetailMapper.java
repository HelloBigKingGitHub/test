package com.hl.mapper;

import com.hl.entity.UserDetail;
import com.hl.entity.Userinfo;

/**
 * userdetail数据库表的mapper接口
 * @author hl
 *
 */
public interface UserDetailMapper {
	

	/**
	 * 插入用户详细信息
	 * @param userDetail
	 * @return
	 */
	int insertUserDetail(UserDetail userDetail);

	
	/**
	 * 更新用户详细信息
	 * @param userDetail
	 * @return
	 */
	int updateUserDetail(UserDetail userDetail);

	
	/**
	 * 得到用户详细信息
	 * @param userDetail
	 * @return
	 */
	UserDetail getUserDetail(UserDetail userDetail);


	/**
	 * 根据用户详细信息更新icon字段
	 * @param userDetail
	 * @return
	 */
	boolean updateUserDetailIcon(UserDetail userDetail);


	/**
	 * 根据用户得到用户的头像信息
	 * @param currentUser
	 * @return
	 */
	String getUserIcon(Userinfo currentUser);


}
