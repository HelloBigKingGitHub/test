package com.hl.service;

import com.hl.entity.Score;

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

}
