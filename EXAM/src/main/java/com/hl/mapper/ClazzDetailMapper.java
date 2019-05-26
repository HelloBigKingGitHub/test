package com.hl.mapper;

import java.util.List;

import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.File;
import com.hl.entity.UserDetail;

/**
 * 
 * <p>Title: ClazzDetailMapper</p>  
 * <p>Description: 班级详细新的mapper接口层</p>  
 * @author huangliang 
 * @date 2019年5月6日
 */
public interface ClazzDetailMapper {

	List<File> getFilesByClassid(int classidInt);

	UserDetail getTeacherByClassid(int classidInt);

	List<UserDetail> getStudentsByClassid(int classidInt);

	List<ClazzAnnouncement> getAnnouncementsByClassid(int classidInt);

}
