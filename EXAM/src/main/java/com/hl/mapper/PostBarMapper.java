package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.PostBar;

/**
 * 
 * <p>Title: PostBarMapper</p>  
 * <p>Description: 帖子的mapper代理接口</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
public interface PostBarMapper {

	/**
	 * 
	 * <p>Title: addPostBar</p>  
	 * <p>Description: 添加一条帖子记录</p> 
	 * <p>data:2019年4月24日 下午10:06:54 </p> 
	 * @param postBar
	 * @return
	 */
	int addPostBar(PostBar postBar);

	
	/**
	 * 
	 * <p>Title: listPostBarByTitle</p>  
	 * <p>Description: 查询所有的帖子信息</p> 
	 * <p>data:2019年4月27日 下午3:22:57 </p> 
	 * @param title
	 * @return
	 */
	List<PostBar> listPostBarByTitle(@Param("questitle")String title);


	/**
	 * 
	 * <p>Title: getPostBarByPbid</p>  
	 * <p>Description: 根据pbid得到帖子内容</p> 
	 * <p>data:2019年4月27日 下午8:14:11 </p> 
	 * @param pbidInt
	 * @return
	 */
	PostBar getPostBarByPbid(int pbidInt);


	/**
	 * 
	 * <p>Title: update</p>  
	 * <p>Description: 更新帖子信息中的字段</p> 
	 * <p>data:2019年4月27日 下午8:18:57 </p> 
	 * @param quescount
	 * @param liulancount
	 * @param liulantime
	 * @param pbid
	 * @return
	 */
	int update(@Param("quescount")int quescount, @Param("liulancount")String liulancount, @Param("liulantime")String liulantime, @Param("pbid")int pbid);
	
	

}
