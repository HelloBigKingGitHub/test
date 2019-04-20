package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.Score;
import com.hl.entity.ScoreDetail;

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

	 
	 /**
	  * 插叙学生的成绩，根据相应的条件进行拼接字符串
	  * @param userid
	  * @param pidInt
	  * @param ptitle
	  * @param teacheridInt
	  * @return
	  */
	List<ScoreDetail> listScoreByUser(@Param(value="userid")int userid, @Param(value="pid")Integer pidInt,
			@Param(value="papername")String ptitle, @Param(value="teacherid")Integer teacheridInt);

}
