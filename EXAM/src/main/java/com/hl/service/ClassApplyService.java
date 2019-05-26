package com.hl.service;

import java.util.Map;

import com.hl.entity.Userinfo;

/**
 * 班级申请服务的接口类
 * @author hl
 *
 */
public interface ClassApplyService {
	
	/**
	 * 添加申请信息
	 * @param classid
	 * @param userid
	 * @return
	 */
	public boolean insertClassApply(Integer classid, Integer userid);

	
	/**
	 * 
	 * <p>Title: listUserAllClassApply</p>  
	 * <p>Description: 展示用户收到的所有申请信息</p> 
	 * <p>data:2019年5月4日 下午12:55:57 </p> 
	 * @param user
	 * @return
	 */
	public Map<String, Object> listUserAllClassApply(String pageStr, String limitStr, Userinfo user);


	/**
	 * 
	 * <p>Title: agreeStudentJoinClass</p>  
	 * <p>Description: 对申请信息进行处理</p> 
	 * <p>data:2019年5月4日 下午4:05:21 </p> 
	 * @param applyuser
	 * @param classid
	 * @param idea
	 * @return
	 */
	public boolean agreeStudentJoinClass(String applyuser, String classid, String idea);

}
