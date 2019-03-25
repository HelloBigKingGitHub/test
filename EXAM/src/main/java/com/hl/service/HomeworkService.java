package com.hl.service;

import com.hl.entity.Homework;
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

	
}
