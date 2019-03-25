package com.hl.service;

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

}
