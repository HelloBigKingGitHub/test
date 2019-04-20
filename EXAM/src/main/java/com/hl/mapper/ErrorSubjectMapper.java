package com.hl.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.ErrorSubject;
import com.hl.entity.Subject;
import com.hl.entity.Userinfo;

public interface ErrorSubjectMapper {
	
	/**
	 * 增加一条错题信息记录 
	 * @param errorSubject
	 * @return 返回操作数，成功则返回正整数
	 */
	int insertErrorSubject(ErrorSubject errorSubject);
	
	/**
	 * 判断该错题在数据库中是否已经存在了
	 * @param errorSubject
	 * @return 返回错题对象
	 */
	ErrorSubject errorSubjectIsExist(ErrorSubject errorSubject);
	
	/**
	 * 查询所有的错题信息
	 * @return
	 */
	List<ErrorSubject> listErrorSubject();
	
	/**
	 * 根据题目查询出做错错着个题目所有考试人
	 * @param subject
	 * @return 返回着学生的主要信息 使用set集合是为了避免重复的userinfo信息
	 */
	Set<Userinfo> queryUserOfErrorSubject(Subject subject);

	/**
	 * 根据试题的编号查询出所有错题
	 * @param id
	 * @return
	 */
	int getErrorCountBySid(Integer id);

	/**
	 * 
	 * <p>Title: listErrorSubjectByUserid</p>  
	 * <p>Description:根据用户id和试题题干查询错题信息 </p> 
	 * <p>data:2019年4月14日 下午4:39:35 </p> 
	 * @param userid
	 * @param scontent
	 * @return
	 */
	List<ErrorSubject> listErrorSubjectByUserid(@Param(value="userid")int userid,  @Param("scontent")String scontent);

	/**
	 * <p>Title: updateErrorSubjectLogicDelete</p>  
	 * <p>Description: 修改试题的逻辑删除状态（0：存在  1：删除）</p> 
	 * <p>data:2019年4月14日 下午10:26:53 </p> 
	 * @param userid
	 * @param esidInt
	 * @return
	 */
	boolean updateErrorSubjectLogicDelete(int userid, int esidInt);

}
