package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.Score;
import com.hl.entity.Userinfo;

/**
 * 成绩单的服务层
 * @author hl
 *
 */
public interface ScoreService {
	
	/**
	 * 增加一条新的成绩单记录
	 * @param score
	 * @return 返回一个Boolean值
	 */
	boolean insertScore (Score score);
	

	/**
	 * 分页根据用户查询成绩
	 * @param page
	 * @param limit
	 * @param user
	 * @param pid   检索条件
	 * @param ptitle  检索条件
	 * @param teacherid 检索条件
	 * @return
	 */
	Map<String, Object> listScoreByUser(String page, String limit, Userinfo user, String pid, String ptitle,
			String teacherid);


	/**
	 * 
	 * <p>Title: listScoreByUserForChart</p>  
	 * <p>Description: 查询成绩信息显示给柱状图</p> 
	 * <p>data:2019年4月17日 下午9:15:41 </p> 
	 * @param user
	 * @return
	 */
	Map<String, String> listScoreByUserForChart(Userinfo user);

}
