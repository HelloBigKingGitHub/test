package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.ChoseSubject;
import com.hl.entity.SubjectDetail;

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

	/**
	 * 跟新题目内容
	 * @param choseSubject
	 * @return
	 */
	boolean updataChoseSubject(ChoseSubject choseSubject);

	/**
	 * 根据试题id的到试题的详细信息
	 * @param sid
	 * @return
	 */
	SubjectDetail getSubjectDetail(String sid);
	
	/**
	 * 通过编号集合批量的查询出试题信息（题干，和选项即可，不需要跟多的列）
	 * @param sid
	 * @return
	 */
	List<ChoseSubject> listChoseSubjectByIds(List<String> subjectidList);

	/**
	 * 添加试题信息并得到试题的sid
	 * @param choseSubject
	 * @return sid
	 */
	int insertSubjectAndGetSid(ChoseSubject choseSubject);

	

}
