package com.hl.mapper;

import java.util.List;

import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.Message;

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

	/**
	 * 得到用户的所有班级公告
	 * @param userid
	 * @return
	 */
	public List<Message> getClassAnnouncementOfUser(Integer userid);

}
