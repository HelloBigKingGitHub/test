package com.hl.mapper;

import java.util.List;

import com.hl.entity.Homework;
import com.hl.entity.Message;

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

	
	/**
	 * 多表查询(查询出学生的班级作业)，连接class_homwork class user_class
	 * @param userid
	 * @return
	 */
	List<Message> getHomeworkFromClass(Integer userid);
	
	
	
    /**
     * 多表查询（查询出学生的个人作业）连接user_homework sysuser
     * @param userid
     * @return
     */
	List<Homework> getHomeworkFromStudent(Integer userid);

}
