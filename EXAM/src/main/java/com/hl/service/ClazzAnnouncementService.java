package com.hl.service;

import java.util.Map;

import com.hl.entity.Userinfo;

/**
 * 班级公告的服务层
 * @author hl
 *
 */
public interface ClazzAnnouncementService {
	
	/**
	 * 根据班级id发布班级公告
	 * @param classid 班级id
	 * @param catitle 公告标题
	 * @param camsg  公告内容
	 * @return
	 */
	boolean addClassAnnouncement(String classid, String catitle ,String camsg);

	/**
	 * 分页得到用户加入班级的所有公告消息
	 * @param page
	 * @param limit
	 * @param user
	 * @return
	 */
	Map<String, Object> getAnnountcement(String page, String limit, Userinfo user);

}
