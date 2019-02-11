package com.hl.service;

import java.util.List;

import com.hl.entity.Paper;
import com.hl.entity.PaperDetail;

/**
 * 有关试卷的service层接口
 * @author hl
 *
 */
public interface PaperService {
	/**
	 * 查询所欲的考试试卷
	 * @return 试卷集合
	 */
	List<Paper>PaperList();
	
	/**
	 * 跟新试卷详细信息
	 * @param paperDetail
	 * @return
	 */
	boolean updataPaperDetail(PaperDetail paperDetail);

}
