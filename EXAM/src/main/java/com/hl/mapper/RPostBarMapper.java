package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.RPostBar;

/**
 * 
 * <p>Title: RPostBarMapper</p>  
 * <p>Description: 回帖的数据库表的mapper接口层</p>  
 * @author huangliang 
 * @date 2019年4月27日
 */
public interface RPostBarMapper {

	/**
	 * 
	 * <p>Title: listRPostBar</p>  
	 * <p>Description: 查询某个帖子的所有回帖</p> 
	 * <p>data:2019年4月27日 下午7:51:55 </p> 
	 * @param pbidInt
	 * @return
	 */
	List<RPostBar> listRPostBar(@Param("pbid")int pbidInt);

	/**
	 * 
	 * <p>Title: addRPostBar</p>  
	 * <p>Description: 添加回帖内容</p> 
	 * <p>data:2019年5月2日 下午2:35:01 </p> 
	 * @param rPostBar
	 * @return
	 */
	int addRPostBar(RPostBar rPostBar);

}
