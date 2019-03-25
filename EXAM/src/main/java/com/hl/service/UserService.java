package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.UserDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.UserSetBean;

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

	/**
	 * 分页查询出用户信息中所有的学生记录
	 * @param page
	 * @param limit
	 * @return
	 */
	Map<String, Object> listStudent(String page, String limit);

	/**
	 * 查询出用户信息中所有的老师记录
	 * @param page
	 * @param limit
	 * @return
	 */
	List<Userinfo> listTeacher();
	

	/**
	 * 更新用户的真实姓名
	 * @param user
	 * @return
	 */
	boolean updateUsertruename(Userinfo user);

	
	/**
	 * 根据新老密码进行密码重置
	 * @param nowpass
	 * @param pass
	 * @param user
	 * @return 重置后的密码
	 */
	String resetUserPassword(String nowpass, String pass,Userinfo user);
	
	

}
