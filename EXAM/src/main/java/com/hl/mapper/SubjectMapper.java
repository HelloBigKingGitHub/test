package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.ChoseSubject;

/**
 * 题目的代理接口
 * @author hl
 *
 */
public interface SubjectMapper {
	
	
	/**
	 * 查询所有的题目信息
	 * @return 题目列表
	 */
	List<ChoseSubject> listChoseSubject();
	
	/**
	 * 通过题干信息进行模糊查询
	 * @param scontent 关键词
	 * @return
	 */
	List<ChoseSubject> listChoseSubjectLikeScontent(@Param("keyword")String scontent);//@Param("keyword")绑定参数用的
	
	/**
	 * 增加一条新的题目
	 * @param choseSubject
	 * @return 操作数
	 */
	int insertSubject(ChoseSubject choseSubject); 

}
