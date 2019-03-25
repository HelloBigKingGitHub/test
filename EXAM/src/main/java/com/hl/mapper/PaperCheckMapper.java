package com.hl.mapper;

import java.util.List;

import com.hl.entity.PaperCheck;
import com.hl.entity.PaperDetail;

/**
 * paper_check表的mapper层接口
 * @author 
 *
 */
public interface PaperCheckMapper {

	/**
	 * 增加一条审查记录
	 * @param paperCheck
	 * @return 操作数
	 */
	int insertPaperCheck(PaperCheck paperCheck);
	

	/**
	 * 根据教师编号查询出所有该教师需要审查的试卷
	 * @param teacher
	 * @return
	 */
	List<PaperDetail> listCheckPaperByTeacherId(Integer teacher);

}
