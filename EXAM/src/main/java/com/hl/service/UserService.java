package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.Userinfo;

/**
 * 业务层逻辑
 * @author admin
 *
 */
public interface UserService {
	/**
	 * 展示所有的用户
	 * @return
	 */
	List<Userinfo> listUserinfo();
	
	/**
	 * 分页展示用户信息
	 * @param pageNum 第几页
	 * @param pageSize 页的大小
	 * @return 返回当前页的所有对象和数据的总数
	 */
	Map<String,Object> listPageUserinfo(Integer pageNum,Integer pageSize);
	
	/**
	 * 用户注册业务逻辑接口
	 * @param userinfo
	 * @return
	 */
	boolean userRegister(Userinfo userinfo);
	
	/**
	 * 用户登录的业务逻辑接口
	 * @param userinfo
     */
	Userinfo userLogin(Userinfo userinfo);

}
