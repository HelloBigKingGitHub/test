package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.PaperCheck;
import com.hl.entity.Userinfo;

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

	/**
	 * 
	 * <p>Title: deleteCheckPaper</p>  
	 * <p>Description: 删除指定的试卷审查记录</p> 
	 * <p>data:2019年5月2日 下午4:04:51 </p> 
	 * @param pid
	 * @param checkteacherid
	 * @return
	 */
	public boolean deleteCheckPaper(String pid, String checkteacherid);

	/**
	 * 
	 * <p>Title: getCheckResult</p>  
	 * <p>Description: 得到审查结果</p> 
	 * <p>data:2019年5月2日 下午4:31:23 </p> 
	 * @param pid
	 * @param checkteacherid
	 * @return
	 */
	public List<String> getCheckResult(String pid);

	/**
	 * 
	 * <p>Title: CheckPaper</p>  
	 * <p>Description: 审查试卷</p> 
	 * <p>data:2019年5月2日 下午5:24:49 </p> 
	 * @param pid
	 * @param checkcontent
	 * @param user
	 * @return
	 */
	public boolean CheckPaper(String pid, String checkcontent, Userinfo user);

}
