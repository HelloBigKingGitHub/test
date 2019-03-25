package com.hl.mapper;

import com.hl.entity.ClazzAnnouncement;

/**
 * 
 * 数据库表中clazz_announcement表的操作接口
 * @author hl
 *
 */
public interface ClazzAnnouncementMapper {
	
	/**
	 * 往数据表中插入一条班级公告记录
	 * @param clazzAnnouncement
	 * @return
	 */
	public int insertClazzAnnouncement(ClazzAnnouncement clazzAnnouncement);

}
