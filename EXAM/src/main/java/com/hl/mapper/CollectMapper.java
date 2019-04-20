package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.Collect;

/**
 * 
 * <p>Title: CollectMapper</p>  
 * <p>Description:用户收集表的数据操作层 </p>  
 * @author huangliang 
 * @date 2019年4月14日
 */
public interface CollectMapper {

	/**
	 * 
	 * <p>Title: insertCollect</p>  
	 * <p>Description:向数据库中插入一条新的记录 </p> 
	 * <p>data:2019年4月14日 下午8:12:37 </p> 
	 * @param userid
	 * @param sid
	 * @param pid
	 * @param contenttype
	 * @return
	 */
	int insertCollect(int userid, int sid, int pid, String contenttype);

	/**
	 * 
	 * <p>Title: collectIsExist</p>  
	 * <p>Description:判断记录书否存在 </p> 
	 * <p>data:2019年4月14日 下午8:12:33 </p> 
	 * @param userid
	 * @param i
	 * @param sidInt
	 * @return
	 */
	int collectIsExist(int userid, int pid, int sidInt);

	/**
	 * 
	 * <p>Title: listCollectByUserid</p>  
	 * <p>Description: 查询用户的收藏</p> 
	 * <p>data:2019年4月15日 下午9:32:42 </p> 
	 * @param userid
	 * @param contentType
	 * @return
	 */
	List<Collect> listCollectByUserid(@Param("userid")int userid,  @Param("contentType")String contentType);

	/**
	 * 
	 * <p>Title: deleteConlletByConllectid</p>  
	 * <p>Description: 根据收藏id删除收藏记录</p> 
	 * <p>data:2019年4月16日 下午10:26:11 </p> 
	 * @param collectidInt
	 * @return
	 */
	boolean deleteConlletByConllectid(int collectidInt);

}
