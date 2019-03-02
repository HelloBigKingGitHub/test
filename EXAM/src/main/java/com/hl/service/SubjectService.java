package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.ChoseSubject;

/**
 * 试题的业务层接口
 * @author hl
 *
 */
public interface SubjectService {
	
	/**
	 * 查询所有的题目信息
	 * @return
	 */
	List<ChoseSubject> listChoseSubject();
	
	/**
	 * 分页查询试题信息
	 * @param pageNum 当前分页
	 * @param pageSize 分页大小
	 * @return map集合，包括查询到的结果和一些页面信息
	 */
	Map<String,Object> listChoseSubjectPage(Integer pageNum, Integer pageSize );
	
	/**
	 * 分题干信息分页查询题目信息
	 * @param pageNum 当前分页
	 * @param pageSize 分页大小
	 * @param scontent 题干内容
	 * @return  map集合，包括查询到的结果和一些页面信息
	 */
	Map<String,Object> listChoseSubjectLikeScontentPage(Integer pageNum, Integer pageSize,String scontent );
	
	
	/**
	 * 增加新的题目
	 * @param choseSubject
	 * @return
	 */
	boolean insertChoseSubject(ChoseSubject choseSubject);

}
