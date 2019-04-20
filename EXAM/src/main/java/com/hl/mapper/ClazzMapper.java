package com.hl.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.Clazz;
import com.hl.entity.ClazzDetail;
import com.hl.entity.Userinfo;

/**
 * 操作clzz表的mapper接口
 * @author admin
 *
 */
public interface ClazzMapper {

	/**
	 * 通过老师的id查询出这位老师创建的所有班级
	 * @param teacherid
	 * @return 班级列表
	 */
	List<Clazz> listClazzByTeacherid(Integer teacherid);

	/**
	 * 往班级表中增加一条数据
	 * @param clazz
	 * @return
	 */
	int insertClazz(Clazz clazz);
	

	/**
	 * 根据班级id或者相关的学生信息查询出所有该班级的学生
	 * @param classid
	 * @return
	 */
	List<Userinfo> listStudentOfClazzByClassid(Map<String,Object> select);

	/**
	 * 往 user_clazz表中添加一条数据
	 * @param clazz
	 * @param student
	 * @return 操作数 (-1表示记录已存在，0表示数据库操作失败，1-∞表示成功)
	 */
	int addStudent(Integer clazz, Integer student);

	/**
	 * 在user_clazz表中查询指定班级和学生的记录是否存在
	 * @param clazz
	 * @param student
	 * @return
	 */
	Userinfo getStudent(Integer clazz, Integer student);

	/**
	 * 根据班级信息查询班级详细信息 操作的表有  clazz sysuser user_clazz clazz_homework clazz_file
	 * @param classid
	 * 
	 * @return ClazzDetail
	 */
	ClazzDetail getClassDetail(Integer classid);

	/**
	 * 给班级添加文件
	 * @param clazzid
	 * @param fileid
	 * @param title
	 * @return
	 */
	int addFile(Integer clazzid, Integer fileid, String title);

	/**
	 * 往 user_clazz表中删除一条数据
	 * @param classid
	 * @param studentid
	 * @return
	 */
	int deleteStudent(Integer classid, Integer studentid);
	
	/**
	 * 跟新班级表中的班级人数字段
	 * @param classid
	 * @param newnum
	 * @return
	 */
	int updatePeoplenum(Integer classid, Integer newnum);
	
	/**
	 * 查询班级的现有人数
	 * @param classid
	 * @return
	 */
	int getPeoplenum(Integer classid);

	/**
	 * 通过班级名称进行模糊查询
	 * @param classname
	 * @return
	 */
	List<Clazz> listClazzByClassname( @Param(value = "classname") String classname);

	/**
	 * 通过用户id查询出该用户加入过的所有班级
	 * @param studentId
	 * @return
	 */
	List<Clazz> listClazzByStudentId(@Param(value="studentid")Integer studentId, @Param(value="classname")String classname);
}
