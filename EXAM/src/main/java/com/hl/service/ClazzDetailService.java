package com.hl.service;

import java.util.List;

import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.File;
import com.hl.entity.UserDetail;

public interface ClazzDetailService {

	/**
	 * 
	 * <p>Title: getFilesByClassid</p>  
	 * <p>Description: 得到班级文件</p> 
	 * <p>data:2019年5月6日 上午9:08:32 </p> 
	 * @param classid
	 * @return
	 */
	List<File> getFilesByClassid(String classid);

	/**
	 * 
	 * <p>Title: getTeacherByClassid</p>  
	 * <p>Description: 查询班主任详细信息</p> 
	 * <p>data:2019年5月6日 上午9:11:39 </p> 
	 * @param classid
	 * @return
	 */
	UserDetail getTeacherByClassid(String classid);

	
	
	/**
	 * 
	 * <p>Title: getStudentsByClassid</p>  
	 * <p>Description: 得到班级中所有的学生</p> 
	 * <p>data:2019年5月6日 上午9:13:42 </p> 
	 * @param classid
	 * @return
	 */
	List<UserDetail> getStudentsByClassid(String classid);

	/**
	 * 
	 * <p>Title: getAnnouncementsByClassid</p>  
	 * <p>Description: 得到班级中的所有公告信息</p> 
	 * <p>data:2019年5月6日 上午9:16:28 </p> 
	 * @param classid
	 * @return
	 */
	List<ClazzAnnouncement> getAnnouncementsByClassid(String classid);

}
