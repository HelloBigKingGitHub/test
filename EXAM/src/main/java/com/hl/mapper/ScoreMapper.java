package com.hl.mapper;

import com.hl.entity.Score;

/**
 * 对成绩单进行数据库交互的接口
 * @author hl
 *
 */
public interface ScoreMapper {
	
	/**
	 * 增添一条成绩单记录
	 * @param score
	 * @return 返回操作数，成功则返回正整数
	 */
	 int insertScore(Score score);

}
