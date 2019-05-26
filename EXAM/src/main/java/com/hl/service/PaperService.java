package com.hl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hl.entity.Paper;
import com.hl.entity.PaperDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.PaperFormBean;

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
	

	/**
	 * 根据条件分页查询出所有的试卷
	 * @param page
	 * @param limit
	 * @param teacherid
	 * @param papername
	 * @param paperid
	 * @return
	 */
	Map<String, Object> listPaper(String page, String limit, String teacherid, String papername, String paperid);

	/**
	 * 添加试卷
	 * @param paper
	 * @return
	 */
	boolean addPaper(PaperFormBean paperFormBean, Userinfo currentUser)throws Exception;

	/**
	 * 
	 * <p>Title: updatePaperState</p>  
	 * <p>Description: 更新paper表中state字段</p> 
	 * <p>data:2019年5月2日 下午5:39:09 </p> 
	 * @param i
	 */
	void updatePaperState(int i ,int pid);

	

}
