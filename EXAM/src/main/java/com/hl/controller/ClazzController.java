package com.hl.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.ClassApply;
import com.hl.entity.Clazz;
import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.ClazzDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.ClazzFormBean;
import com.hl.service.ClassApplyService;
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
	private ClassApplyService classApplyService;
	
	@Autowired
	private ClazzAnnouncementService clazzAnnountcementService;
	
	@RequestMapping(value="list_clazz_by_teacher.action" ,produces = {"text/html;charset=utf-8"})
	public @ResponseBody String listClazzByTeacher(String page,String limit,String teacheridStr) {
		
		HashMap <String,Object>map = (HashMap<String, Object>) clazzService.listClazzByTeacherid(teacheridStr, page, limit);
		return TableUtil.tableRander(Clazz.class, map, "list");
	}
	
	/**
	 * 根据班级名称进行查询出所有的班级记录
	 * @param page
	 * @param limit
	 * @param classname
	 * @return
	 */
	@RequestMapping(value="list_clazz_by_classname.action" ,produces = {"text/html;charset=utf-8"})
	public @ResponseBody String listClazzByClassname(String page,String limit,String classname) {
		
		HashMap <String,Object>map = (HashMap<String, Object>) clazzService.listClazzByClassname(classname, page, limit);
		return TableUtil.tableRander(Clazz.class, map, "list");
	}
	
	/**
	 * 查询当前用户加入的所有班级
	 * @param session
	 * @return
	 */
	@RequestMapping(value="my_class.action" ,produces = {"text/html;charset=utf-8"})
	public @ResponseBody String myClass(String page,String limit,String classname,HttpSession session) {
		Userinfo user = (Userinfo) session.getAttribute("crruentUser"); 
		HashMap <String,Object>map = (HashMap<String, Object>) clazzService.listClazzByStudent(user,classname,page, limit);
		return TableUtil.tableRander(Clazz.class, map, "list");
	}
	
	/**
	 * 为搜索选择框查询所有的班级信息
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
			msg = "该学生已经加入了该班级,或者人数超标了。。";
		}else if (rs==0) {
			msg = "数据异常";
		}else {
			msg = "添加成功";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 学生申请加入班级
	 * @param classid
	 * @param session
	 * @return
	 */
	@RequestMapping(value="student_apply_to_class.action",produces = {"text/html;charset=utf-8"})
	public @ResponseBody String studentApplyToClass(String classid , HttpSession session) {
		
		JSONObject result = new JSONObject();
		String msg = "";
		Userinfo user = (Userinfo) session.getAttribute("crruentUser"); 
		boolean isok = clazzService.studentApplyToClass(classid , user);
		if(isok) {
			msg = "申请成功";
		}else {
			msg = "申请失败";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 删除学生
	 * @param classid
	 * @param studentid
	 * @return
	 */
	@RequestMapping(value = "remove_student_from_class.action", produces = {"text/html;charset=utf-8"})
	public  @ResponseBody String removeStudentFromClass(String classid, String studentid) {
		JSONObject result = new JSONObject();
		String msg = "";
		boolean isok = clazzService.deleteStudent(classid,studentid);
		if(isok) {
			msg = "该学生已经移除了该班级";
		}else {
			msg = "后台异常";
		}
		
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 学生主动退出班级
	 * @param classid
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "student_quit_class.action", produces = {"text/html;charset=utf-8"})
	public @ResponseBody String studentQuitClass(String classid, HttpSession session) {
		JSONObject result = new JSONObject();
		String msg = "";
		Userinfo user = (Userinfo) session.getAttribute("crruentUser"); 
		Integer studentid = user.getUserid();
		boolean isok = clazzService.deleteStudent(classid,studentid+"");
		if(isok) {
			msg = "成功退出班级";
		}else {
			msg = "后台异常";
		}
		
		result.put("msg", msg);
		return result.toString();
	}
	
	@RequestMapping(value = "get_class_detail.action" ,produces = {"text/html;charset=utf-8"})
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
	 * 教师发布班级公告
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
	 * 学生得到班级公告信息（仅限学生已经加入的班级）
	 * @return
	 */
	@RequestMapping(value="get_class_announcement_of_student.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String classAnnouncementOfStudent(String page, String limit,HttpSession session) {
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		Map<String, Object> annoucement = clazzAnnountcementService.getAnnountcement(page,limit,user);
		String result = TableUtil.tableRander(ClazzAnnouncement.class, annoucement, "list");
		return result;
	}
	
	
	/**
	 * 上传班级文件
	 * @param file
	 * @param request
	 * @param session
	 * @param classid
	 * @return
	 */
	@RequestMapping(value="upload_file_of_class.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String uploadFileOfClass(MultipartFile file ,HttpServletRequest request,HttpSession session,String classid) {
		JSONObject result = new JSONObject();
		int code = 0;
		String msg = "";
		Userinfo currentUser = (Userinfo) session.getAttribute("crruentUser");
		boolean isok = clazzService.uploadFile(file,request,currentUser,classid);
		if(isok) {
			msg = "上传成功";
		}else {
			msg = "上传失败";
			code = 1;
		}
		result.put("code", code);
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
	
	
	/**
	 * 
	 * <p>Title: listCurrentUserAllClassApply</p>  
	 * <p>Description: 展示所有申请加入当前用户（老师）创建的班级的申请信息</p> 
	 * <p>data:2019年5月4日 下午12:50:33 </p> 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="list_all_class_apply",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String listCurrentUserAllClassApply(String page, String limit, HttpSession session) {
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		Map<String, Object> apply = classApplyService.listUserAllClassApply(page, limit ,user);
		String result = TableUtil.tableRander(ClassApply.class, apply, "list");
		return result;
	}
	
	
	
	
	
	@RequestMapping(value="agree_student_join_class.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String agreeStudentJoinClass(String applyuser, String classid, String idea) {
		JSONObject result = new JSONObject();
		String msg = "";
		boolean isok = classApplyService.agreeStudentJoinClass(applyuser,classid,idea);
		if(isok) {
			msg = "已将该同学加入到班级";
		}else {
			msg = "操作失败";
		}
		result.put("msg", msg);
		return result.toString();
		
	}
	
	
}
