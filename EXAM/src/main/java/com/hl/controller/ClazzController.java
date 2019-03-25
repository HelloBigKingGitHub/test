package com.hl.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Clazz;
import com.hl.entity.ClazzDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.ClazzFormBean;
import com.hl.service.ClazzAnnouncementService;
import com.hl.service.ClazzService;
import com.hl.util.ui.TableUtil;

import net.sf.json.JSONObject;

/**
 * 班级的控制层
 * @author hl
 *
 */

@Controller
public class ClazzController {
	
	@Autowired
	private ClazzService clazzService; 
	
	@Autowired
	private ClazzAnnouncementService clazzAnnountcementService;
	
	@RequestMapping(value="list_clazz_by_teacher.action" ,produces = {"text/html;charset=utf-8"})
	public @ResponseBody String listClazzByTeacher(String page,String limit,String teacheridStr) {
		
		HashMap <String,Object>map = (HashMap<String, Object>) clazzService.listClazzByTeacherid(teacheridStr, page, limit);
		return TableUtil.tableRander(Clazz.class, map, "list");
	}
	
	/**
	 * 为搜索选择框查询所有的课程信息
	 * @param page
	 * @param limit
	 * @param teacheridStr
	 * @return
	 */
	@RequestMapping(value="list_clazz_by_teacher_for_select.action" ,produces = {"text/html;charset=utf-8"})
	public @ResponseBody String listClazzByTeacherForSelect(String teacheridStr) {
	
		JSONObject result = new JSONObject();
		List<Clazz> list = null;
		String msg = "";
		Integer code = 0;
		list = clazzService.listClazzByTeacherid(teacheridStr);
		if(list==null) {
			msg = "没有获取到班级信息";
			code = 1; 
		}
		result.put("msg", msg);
		result.put("code", code);
		result.put("clazzList", list);
		return result.toString();
	}
	
	@RequestMapping(value="add_clazz.action",produces={"text/html;charset=utf-8"})
	public @ResponseBody String addClazzForTeacher(@RequestBody ClazzFormBean clazzFormBean,HttpSession session) {
		
		Clazz clazz = clazzFormBeanToClazz(clazzFormBean,session);
		boolean isok = clazzService.addClazzForTeacher(clazz);
		if(isok) {
			return "添加成功";
		}else{
			return "添加失败";
		}
	}
	
	/**
	 * 根据班级班级、学生姓名或者学生电话查询学生
	 * @param classidStr
	 * @param page
	 * @param limit
	 * @param studentname
	 * @param studenttel
	 * @return
	 */
	@RequestMapping(value="list_student_of_clazz_by_classid.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String listStudentOfClazzByClassid(String classidStr,String page,String limit,String studentname,String studenttel) {
		
		HashMap <String,Object>map = (HashMap<String, Object>) clazzService.listStudentOfClazzByClassid(classidStr, page, limit,studentname,studenttel);
		return TableUtil.tableRander(Userinfo.class, map, "list");
	}
	
	/**
	 * 给班级添加学生
	 * @param classid
	 * @param studentid
	 * @return
	 */
	@RequestMapping(value="add_student_to_class.action",produces = {"text/html;charset=utf-8"})
	public @ResponseBody String addStudentToClass(String classid, String studentid) {
		JSONObject result = new JSONObject();
		String msg = "";
		int rs = clazzService.addStudent(classid,studentid);
		if(rs == -1) {
			msg = "该学生已经加入了该班级";
		}else if (rs==0) {
			msg = "数据异常";
		}else {
			msg = "添加成功";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	@RequestMapping(value="get_class_detail.action" ,produces= {"text/html;charset=utf-8"})
	public @ResponseBody String getClassDetail(String classid) {
		String msg = "";
		Integer code = 0;
		JSONObject result = new JSONObject();
		if(classid == null || "".equals(classid)) {
			msg = "没有获取到班级编号";
		}
		ClazzDetail classdetail = clazzService.getClassDetail( classid);
		if(classdetail!=null) {
			msg = "获取成功";
			code = 1;
			result.put("teacher", classdetail.getTeacher());
			result.put("ClazzFiles", classdetail.getClazzFiles());
			result.put("Homeworks", classdetail.getHomeworks());
			result.put("students", classdetail.getStudents());
		}
		result.put("msg", msg);
		result.put("code", code);
		
		return result.toString();
	}
	
	
	/**
	 * 发布班级公告
	 * @return
	 */
	@RequestMapping(value="issuer_class_announcement.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String issuerClassAnnouncement(String classid, String catitle ,String camsg) {
		JSONObject result = new JSONObject();
		String msg = "";
		boolean isok = clazzAnnountcementService.addClassAnnouncement(classid,catitle,camsg);
		if(isok) {
			msg = "发布成功";
		}else {
			msg = "发布失败";
		}
		result.put("isok", isok);
		result.put("msg", msg);
		return result.toString();
	}
	
	
	/**
	 * 表单提交上来的数据进行转化
	 * @param clazzFormBean
	 * @return clazz
	 */
	private Clazz clazzFormBeanToClazz(ClazzFormBean clazzFormBean,HttpSession session) {
		// TODO Auto-generated method stub
		Clazz clazz = new Clazz();
		clazz.setClassdesrible(clazzFormBean.getClassdesrible());
		clazz.setClassname(clazzFormBean.getClassname());
		clazz.setClassteacherid(((Userinfo)session.getAttribute("crruentUser")).getUserid());//得到当前用户的id值
		clazz.setClasstype(clazzFormBean.getClasstype());
		clazz.setMaxpeoplenum(Integer.parseInt(clazzFormBean.getMaxclasspeople()));
		if(clazzFormBean.getClassstate()==null||"".equals(clazzFormBean.getClassstate())) {
			clazz.setClassstate(0);
		}else {
			clazz.setClassstate(1);
		}
		return clazz;
	}
}
