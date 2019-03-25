package com.hl.service;

import java.util.Map;

import com.hl.entity.PaperCheck;

/**
 * paper_check 的服务层接口
 * @author hl
 *
 */
public interface PaperCheckService {
	
	/**
	 * 增加一条审查记录
	 * @param paperCheck
	 * @return
	 */
	public boolean insertPaperCheck(PaperCheck paperCheck);
	
	/**
	 * 通过老师编号查询出该老需要审查的所有试卷
	 * @param page
	 * @param limit
	 * @param teacherid
	 * @return
	 */
	Map<String, Object> listCheckPaperByTeacherId(String page, String limit, String teacherid);

}
