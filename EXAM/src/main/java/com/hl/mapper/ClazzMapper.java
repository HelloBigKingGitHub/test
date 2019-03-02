package com.hl.mapper;

import java.util.List;

import com.hl.entity.Clazz;
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
	 * 根据班级id查询出所有该班级的学生
	 * @param classid
	 * @return
	 */
	List<Userinfo> listStudentOfClazzByClassid(Integer classid);
}
