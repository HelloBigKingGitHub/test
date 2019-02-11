package com.hl.mapper;



import java.util.List;

import com.hl.entity.Userinfo;

/**
 * 使用的时mybatis的接口代理开发
 * @author admin
 *
 */
public interface UserMapper {
	/**
	 * 查询所有用户信息。
	 * @return 用户信息的一个list集合
	 */
	List<Userinfo> listUserinfo();
	
	/**
	 * 判断用户是否已经存在，根据用户的手机号判断
	 * @param userinfo
	 * @return
	 */
	Userinfo userIsExist(Userinfo userinfo);
	
	/**
	 * 进行用户的插入
	 * @param userinfo
	 * @return
	 */
	int insertUserinfo(Userinfo userinfo);

}
