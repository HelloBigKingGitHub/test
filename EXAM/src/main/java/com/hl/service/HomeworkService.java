package com.hl.service;

import java.util.Map;

import com.hl.entity.Homework;
import com.hl.entity.Userinfo;
import com.hl.formbean.HomeworkFormBean;

/**
 * 作业的服务层
 * @author admin
 *
 */
public interface HomeworkService {
	

	/**
	 * 给指定班级添加作业记录
	 * @param homeworkFormBean
	 * @return Boolean  是否成功
	 */
	boolean addHomeworkForClass(HomeworkFormBean homeworkFormBean);
	
	/**
	 * 添加作业
	 * @param homework
	 * @return Homework对象
	 */
	Homework addHomework(Homework homework);

	
	/**
	 * 根据用户所在的班级分页查询出作业信息
	 * @param page
	 * @param limit
	 * @param user
	 * @return
	 */
	Map<String, Object> getHomeworkFromClass(String page, String limit, Userinfo user);

	
	/**
	 * 根据用户信息查询出作业信息
	 * @param page
	 * @param limit
	 * @param user
	 * @return
	 */
	Map<String, Object> getHomeworkFromStudent(String page, String limit, Userinfo user);

	
}
