package com.hl.mapper;

import java.util.List;

import com.hl.entity.ChoseSubject;
import com.hl.entity.Paper;
import com.hl.entity.PaperDetail;

/**
 * 对试卷进行操作的到层
 * @author hl
 *
 */
public interface PaperMapper {
	/**
	 * 查询所有的试卷，并返回到一个list集合中
	 * @return 试卷集合
	 */
	List<Paper> listPaper();
	
	/**
	 * 根据试卷的id好查询出该试卷中的有的题目
	 * @param pid
	 * @return ChoseSubject的集合
	 */
	List<ChoseSubject> listChoseSubject(String pid);
	
	/**
	 *根据试卷的id号查询试卷的详细信息 
	 * @param pid
	 * @return PaperDetail 试卷的详细信息
	 */
	PaperDetail queryPaperDetailById(String pid);
	
	/**
	 * 跟新数据中试卷的详细信息
	 * @param paperDetail
	 * @return
	 */
	int updataPaperDetail (PaperDetail paperDetail);
	
	

}
