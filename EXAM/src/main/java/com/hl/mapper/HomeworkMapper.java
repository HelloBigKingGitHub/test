package com.hl.mapper;

import com.hl.entity.Homework;

/**
 * 关于homework数据库表以及与其相关的表的mapper接口
 * @author admin
 *
 */
public interface HomeworkMapper {

	
	/**
	 * 添加一条作业数据到homework数据库表中
	 * @param homework
	 * @return
	 */
	int insertHomework(Homework homework);

	/**
	 * 为班级添加作业
	 * @param homeworkid
	 * @param classid
	 * @return
	 */
	int insertHomeForClass(Integer homeworkid, Integer classid);

}
