package com.hl.service;

import java.util.List;
import java.util.Map;

import com.hl.entity.RPostBar;
import com.hl.entity.Userinfo;

/**
 * 
 * <p>Title: PostBarService</p>  
 * <p>Description: 帖子功能的服务功能</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
public interface PostBarService {

	/**
	 * 
	 * <p>Title: addPostBar</p>  
	 * <p>Description: </p> 
	 * <p>data:2019年4月24日 下午9:58:59 </p> 
	 * @param title
	 * @param content
	 * @param reward
	 * @param user
	 * @return code 0:添加成功 1：添加失败 2：文本输入有误
	 */
	int addPostBar(String title, String content, String reward, Userinfo user);
	
	/**
	 * 
	 * <p>Title: updatePostBarByPbid</p>  
	 * <p>Description: 更新帖子中的回答次数，浏览次数，最后浏览时间</p> 
	 * <p>data:2019年4月24日 下午10:14:07 </p> 
	 * @param quescount
	 * @param liulancount
	 * @param liulantime
	 * @return
	 */
	int updatePostBarByPbid(int quescount,String liulancount,String liulantime, String qbid);
	
	/**
	 * 
	 * <p>Title: listCourseByTeacher</p>  
	 * <p>Description: 根据条件查询多个帖子,分页</p> 
	 * <p>data:2019年4月24日 下午10:24:39 </p> 
	 * @param user
	 * @param page
	 * @param limit
	 * @param coursename
	 * @return
	 */
	Map<String, Object> listPostBarByTitle(String page, String limit, String title);
	
	
	/**
	 * 
	 * <p>Title: showPostBarByPbid</p>  
	 * <p>Description: 展示帖子的回复</p> 
	 * <p>data:2019年4月24日 下午10:29:41 </p> 
	 * @param pbid
	 * @return
	 */
	List<RPostBar> showRPostBarByPbid(String pbid);

	/**
	 * 
	 * <p>Title: showPostBarDetailByPbid</p>  
	 * <p>Description: 展示帖子的内容和他所有的回帖</p> 
	 * <p>data:2019年4月27日 下午7:59:34 </p> 
	 * @param pbid
	 * @return
	 */
	Map<String, Object> showPostBarDetailByPbid(String pbid);

}
