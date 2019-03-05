package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.Clazz;

/**
 * 对课程的服务层
 * @author hl
 *
 */
public interface ClazzService {
	
	/**
	 * 根据老师的编号查询出所有课程
	 * @param teacheridStr 老师编号
	 * @param pageNumStr      当前分页
	 * @param PageSizeStr     分页大小
	 * @return             课程列表
	 */
	Map<String,Object> listClazzByTeacherid(String teacheridStr,String pageNumStr,String PageSizeStr);
	
	/**
	 * 不使用分页的方式查询出所有的课程信息
	 * @param pageSizeStr
	 * @return
	 */
	List<Clazz> listClazzByTeacherid(String teacheridStr);
	
	/**
	 * 老师添加班级
	 * @param clazz
	 * @return
	 */
	boolean addClazzForTeacher(Clazz clazz);
	
	/**
	 * 根据班级信息查询出所有该班级的学生
	 * @param classidStr 班级的id号
	 * @param page 当前分页
	 * @param limit 分页大小
	 * @return 包含分页信息的map集合
	 */
	Map<String, Object> listStudentOfClazzByClassid(String classidStr, String pageStr, String limitStr, String studentname,String studenttel);

}
