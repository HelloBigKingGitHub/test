
package com.hl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Clazz;
import com.hl.entity.ClazzDetail;
import com.hl.entity.ClazzFile;
import com.hl.entity.Homework;
import com.hl.entity.Userinfo;
import com.hl.mapper.ClazzMapper;
import com.hl.service.ClazzService;
/**
 * Clazz服务层的实现类
 * @author hl
 *
 */
@Service
public class ClazzServiceImpl implements ClazzService{
	
	@Autowired
	private ClazzMapper clazzMapper;

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

}
