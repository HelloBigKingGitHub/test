package com.hl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.File;
import com.hl.entity.UserDetail;
import com.hl.service.ClazzDetailService;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: ClazzDetailController</p>  
 * <p>Description: 后期加上的一个控制器，负责显示班级详细内容</p>  
 * @author huangliang 
 * @date 2019年5月5日
 */
@Controller
public class ClazzDetailController {
	
	@Autowired
	private ClazzDetailService clazzDetailService;
	
	
	/**
	 * 
	 * <p>Title: getClassFilesByClassid</p>  
	 * <p>Description: 得到某个班级的所有文件</p> 
	 * <p>data:2019年5月6日 上午8:48:48 </p> 
	 * @return
	 */
	@RequestMapping(value="get_class_files_by_classid.action" ,produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String getClassFilesByClassid(String classid) {
		List<File> files = clazzDetailService.getFilesByClassid(classid);
		JSONObject result = new JSONObject();
		result.put("files", files);
		return result.toString();
	}
	
	/**
	 * 
	 * <p>Title: getTeacherByClassid</p>  
	 * <p>Description: 根据班级id得到班级班主任的信息</p> 
	 * <p>data:2019年5月6日 上午8:50:20 </p> 
	 * @return
	 */
	@RequestMapping(value="get_teacher_by_classid.action" ,produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String getTeacherByClassid(String classid) {
		JSONObject result = new JSONObject();
		UserDetail teacher = clazzDetailService.getTeacherByClassid(classid);
		result.put("teacher", teacher);
		return result.toString();
	}
	
	/**
	 * 
	 * <p>Title: getTeacherByClassid</p>  
	 * <p>Description: 根据班级id得到班级的所有学生</p> 
	 * <p>data:2019年5月6日 上午8:50:20 </p> 
	 * @return
	 */
	@RequestMapping(value="get_students_by_classid.action" ,produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String getStudentsByClassid(String classid) {
		JSONObject result = new JSONObject();
		List<UserDetail> students = clazzDetailService.getStudentsByClassid(classid);
		result.put("teacher", students);
		return result.toString();
	}
	
	/**
	 * 
	 * <p>Title: getTeacherByClassid</p>  
	 * <p>Description: 根据班级id得到班级的所有公告信息</p> 
	 * <p>data:2019年5月6日 上午8:50:20 </p> 
	 * @return
	 */
	@RequestMapping(value="get_announcements_by_classid.action" ,produces = {"text/html;charset=utf-8"})
	@ResponseBody
	public String getAnnouncementsByClassid(String classid) {
		JSONObject result = new JSONObject();
		List<ClazzAnnouncement> announcements = clazzDetailService.getAnnouncementsByClassid(classid);
		result.put("announcements", announcements);
		return result.toString();
	}

}
