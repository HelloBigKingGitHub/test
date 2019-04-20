package com.hl.service;

import java.util.Map;

import com.hl.entity.Userinfo;

/**
 * 
 * <p>Title: CollectService</p>  
 * <p>Description: 收藏业务的业务层</p>  
 * @author huangliang 
 * @date 2019年4月14日
 */
public interface CollectService {

	/**
	 * 
	 * <p>Title: userCollectSubject</p>  
	 * <p>Description:用户收藏试题subjec </p> 
	 * <p>data:2019年4月14日 下午2:42:49 </p> 
	 * @param user
	 * @param sid
	 * @return
	 */
	boolean userCollectSubject(Userinfo user, String sid);

	/**
	 * 
	 * <p>Title: userCollectPaper</p>  
	 * <p>Description:用户收藏试卷paper </p> 
	 * <p>data:2019年4月14日 下午2:42:53 </p> 
	 * @param user
	 * @param pid
	 * @return
	 */
	boolean userCollectPaper(Userinfo user, String pid);

	/**
	 * 
	 * <p>Title: getUserCollect</p>  
	 * <p>Description: 用户分页查询自己的收藏信息</p> 
	 * <p>data:2019年4月15日 下午9:27:44 </p> 
	 * @param limit
	 * @param page
	 * @param contentType
	 * @param user
	 * @return
	 */
	Map<String, Object> getUserCollect(String limit, String page, String contentType, Userinfo user);

	/**
	 * 
	 * <p>Title: deleteConlletByConllectid</p>  
	 * <p>Description: 根据收藏id删除收藏记录</p> 
	 * <p>data:2019年4月16日 下午10:22:34 </p> 
	 * @param collectid
	 * @return
	 */
	boolean deleteConlletByConllectid(String collectid);

}
