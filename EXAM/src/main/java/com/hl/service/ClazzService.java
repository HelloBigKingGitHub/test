package com.hl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.Clazz;
import com.hl.entity.ClazzDetail;
import com.hl.entity.Userinfo;

/**
 * 对课程的服务层
 * @author hl
 *
 */
public interface ClazzService {
	
	/**
	 * 根据老师的编号查询出所有班级
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

	/**
	 * 往班级中添加学生
	 * @param classid
	 * @param studentid
	 * @return
	 */
	int addStudent(String classid, String studentid);
	
	/**
	 * 判断学生是否在这个班级中
	 * @param classid
	 * @param studentid
	 * @return 返回着个学生的全部信息
	 */
	Userinfo studentInClass(String classid, String studentid);

	/**
	 * 根据班级编号查询班级详细信息
	 * @param classid
	 * @return
	 */
	ClazzDetail getClassDetail(String classid);

	/**
	 * 上传班级文件
	 * @param file
	 * @param request
	 * @param session
	 * @param classid
	 * @return
	 */
	boolean uploadFile(MultipartFile file, HttpServletRequest request, Userinfo user, String classid);

	/**
	 * 从班级中删除学生
	 * @param classid
	 * @param studentid
	 * @return
	 */
	boolean deleteStudent(String classid, String studentid);

	/**
	 * 用户申请加入相应的班级
	 * @param classid
	 * @param user
	 * @return
	 */
	boolean studentApplyToClass(String classid, Userinfo user);

	/**
	 * 根据班级的名称查询出所有的班级信息
	 * @param classname
	 * @param page
	 * @param limit
	 * @return
	 */
	Map<String, Object> listClazzByClassname(String classname, String page, String limit);

	/**
	 * 查询出学生加入的所有班级
	 * @param page
	 * @param limit
	 * @return
	 */
    Map<String, Object> listClazzByStudent(Userinfo user, String classname ,String page, String limit);



	

}
