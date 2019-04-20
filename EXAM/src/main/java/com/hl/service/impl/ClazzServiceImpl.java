
package com.hl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Clazz;
import com.hl.entity.ClazzDetail;
import com.hl.entity.ClazzFile;
import com.hl.entity.File;
import com.hl.entity.Homework;
import com.hl.entity.Userinfo;
import com.hl.mapper.ClazzMapper;
import com.hl.service.ClassApplyService;
import com.hl.service.ClazzService;
import com.hl.service.FileService;
import com.hl.util.file.FileUploadUtil;
import com.hl.util.string.StringUtil;
/**
 * Clazz服务层的实现类
 * @author hl
 *
 */
@Service
public class ClazzServiceImpl implements ClazzService{
	
	@Autowired
	private ClazzMapper clazzMapper;
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private ClassApplyService classApplyService;

	@Override
	public Map<String,Object> listClazzByTeacherid(String teacheridStr, String pageNumStr, String pageSizeStr) {
		if(teacheridStr==null||"".equals(teacheridStr)) {
			return null;
		}
		Integer teacherid = Integer.parseInt(teacheridStr);
		Integer pageNum = Integer.parseInt(pageNumStr);
		Integer pageSize = Integer.parseInt(pageSizeStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Clazz> list = clazzMapper.listClazzByTeacherid(teacherid);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
		
	}
	
	public List<Clazz> listClazzByTeacherid(String teacheridStr){
		if(teacheridStr==null||"".equals(teacheridStr)) {
			return null;
		}
		Integer teacherid = Integer.parseInt(teacheridStr);
		return clazzMapper.listClazzByTeacherid(teacherid);
		
	}

	@Override
	public boolean addClazzForTeacher(Clazz clazz) {
		
		return clazzMapper.insertClazz( clazz) > 0;
	}

	@Override
	public Map<String, Object> listStudentOfClazzByClassid(String classidStr, String pageStr, String limitStr,String studentname,String studenttel) {
		if(classidStr==null||"".equals(classidStr)) {
			return null;
		}
		Integer classid = Integer.parseInt(classidStr);
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Map<String,Object> select = new HashMap<>(); //将查询条件封装进一个map中
		select.put("classid", classid);
		select.put("studentname", studentname!=null?studentname.trim():(studentname = ""));
		select.put("studenttel", studenttel!=null?studenttel.trim():(studenttel = ""));
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Userinfo> list = clazzMapper.listStudentOfClazzByClassid(select);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	

	@Override
	public int addStudent(String classid, String studentid) {
		Integer clazz = null;
		Integer student = null;
		if(classid!=null&&!("".equals(classid))) {
			clazz = Integer.parseInt(classid);
		}
		if(studentid!=null&&!("".equals(studentid))) {
			student = Integer.parseInt(studentid);
		}
		if(studentInClass(classid,studentid)!=null) {//表示记录已经存在了
			return -1;
		}
		Integer oldPeoplenum = clazzMapper.getPeoplenum(clazz);
		Integer newPeoplenum = oldPeoplenum + 1;
		if(clazzMapper.updatePeoplenum(clazz, newPeoplenum) < 0) {// 判断是否超过最大人数了
			return -1;
		}
		return clazzMapper.addStudent(clazz,student);
	}

	@Override
	public Userinfo studentInClass(String classid, String studentid) {
		Integer clazz = null;
		Integer student = null;
		if(classid!=null&&!("".equals(classid))) {
			clazz = Integer.parseInt(classid);
		}
		if(studentid!=null&&!("".equals(studentid))) {
			student = Integer.parseInt(studentid);
		}
		return clazzMapper.getStudent(clazz,student);
	}

	@Override
	public ClazzDetail getClassDetail(String classid) {
		if(classid == null || "".equals(classid)) {
			return null;
		}
		Integer id = Integer.parseInt(classid);
		ClazzDetail classDetail = clazzMapper.getClassDetail(id); //该方法底层使用了多表查询五张表，有些list中数据重复需要去重。
		
		{ //去重逻辑 使用set接受，然后再转化为list即可。实体类需要重写equals和hashCode方法
			Set<Homework> hashSetHomework = new HashSet<Homework>(classDetail.getHomeworks());
			Set<Userinfo> hashSetUserinfo = new HashSet<Userinfo>(classDetail.getStudents());
			Set<ClazzFile> hashSetClazzFile = new HashSet<ClazzFile>(classDetail.getClazzFiles());
			classDetail.setClazzFiles(new ArrayList<ClazzFile>(hashSetClazzFile));
			classDetail.setHomeworks(new ArrayList<Homework>(hashSetHomework));
			classDetail.setStudents(new ArrayList<Userinfo>(hashSetUserinfo));
		}
		
		return classDetail;
	}

	@Override
	public boolean uploadFile(MultipartFile file, HttpServletRequest request, Userinfo user, String classid) {
		
		if(classid == null || "".equals(classid)) {
			return false;
		}
		//1.先上传文件，调用文件的服务层
		File LocalFile = fileService.uploadFile(file,request,user,"班级文件");
		//System.out.println(LocalFile);
		if(LocalFile == null || LocalFile.getFileid() == null) { //如果文件上传失败直接返回false
			return false;
		}
		
		Integer clazzid = Integer.parseInt(classid);
		String title = file.getOriginalFilename();
		boolean isok = clazzMapper.addFile(clazzid,LocalFile.getFileid(),title) > 0;
		if(!isok) { //如果数据更新失败，就要删除刚刚上传的本地文件
			FileUploadUtil.removeLocalFile(LocalFile.getFileurl());
		}
		return isok;
	}

	
	
	@Override
	public boolean deleteStudent(String classidStr, String studentidStr) {
		if(classidStr == null || studentidStr == null 
				|| !StringUtil.isInteger(studentidStr) 
				|| !StringUtil.isInteger(classidStr)) {
			return false; //如果字符串为空或者不是数字就返回false
		}
		Integer classid = Integer.parseInt(classidStr);
		Integer studentid = Integer.parseInt(studentidStr);
		return clazzMapper.deleteStudent(classid,studentid) > 0;
		
	}

	@Override
	public boolean studentApplyToClass(String classid, Userinfo user) {
		if(classid == null || user.getUserid() == null) {
			return false;
		}
		System.out.println(user);
		Integer applyuser = user.getUserid();
		Integer clazzid = Integer.parseInt(classid);
		return classApplyService.insertClassApply(clazzid, applyuser);
	}

	@Override
	public Map<String, Object> listClazzByClassname(String classname, String pageStr, String limit) {
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limit);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Clazz> list = clazzMapper.listClazzByClassname(classname);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public Map<String, Object> listClazzByStudent(Userinfo user, String classname ,String pageStr, String limit) {
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limit);
		Integer studentId = user.getUserid();
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Clazz> list = clazzMapper.listClazzByStudentId(studentId,classname);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

}
