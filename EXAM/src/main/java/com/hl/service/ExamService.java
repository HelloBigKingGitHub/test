package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.ChoseSubject;
import com.hl.entity.PaperDetail;

/**
 * 与考试相关的业务逻辑层
 * @author hl
 *
 */
public interface ExamService {
	
	/**
	 * 根据试卷id好查询出试卷的详细信息和试卷中所包含的试题信息
	 * @param pid
	 * @return 试卷详细信息 题目信息list集合
	 */
	Map<PaperDetail,List<ChoseSubject>> startTest(String pid);
	
	/**
	 * 考试试卷提交的服务类
	 * @param answerMap
	 * @return 返回提交试卷的结果
	 */
	boolean submitTest(Map<String,Object> answerMap);

}
