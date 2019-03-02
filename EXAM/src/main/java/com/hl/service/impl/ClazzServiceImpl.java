
package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Clazz;
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
	public Map<String, Object> listStudentOfClazzByClassid(String classidStr, String pageStr, String limitStr) {
		if(classidStr==null||"".equals(classidStr)) {
			return null;
		}
		Integer classid = Integer.parseInt(classidStr);
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Userinfo> list = clazzMapper.listStudentOfClazzByClassid(classid);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	
	

}
