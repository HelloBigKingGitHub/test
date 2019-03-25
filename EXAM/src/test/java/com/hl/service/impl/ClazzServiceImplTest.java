package com.hl.service.impl;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Clazz;
import com.hl.entity.ClazzDetail;
import com.hl.entity.Homework;
import com.hl.entity.Userinfo;
import com.hl.service.ClazzService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *  单元测试
 * @author hl
 *
 */
public class ClazzServiceImplTest extends BaseTest{
	
	@Autowired
	private ClazzService cs;

	@Test
	public void testListClazzByTeacherid() {
		
		String teacheridStr = "6";
		String pageNumStr = "1";
		String pageSizeStr = "10";
		Map<String ,Object>result = cs.listClazzByTeacherid(teacheridStr, pageNumStr, pageSizeStr);
		List<Clazz>list = (List<Clazz>) result.get("list");
		for (Clazz clazz : list) {
			System.out.println(clazz);
		}
	}
	
	@Test
	public void testAddClazzForTeacher() {
		
		Clazz clazz = new Clazz();
		clazz.setClassdesrible("测试描述");
		clazz.setClassname("测试名字");
		clazz.setClassstate(1);
		clazz.setClassteacherid(6);
		clazz.setClasstype("实验班");
		clazz.setMaxpeoplenum(60);
		
		System.out.println(cs.addClazzForTeacher(clazz));
	}
	
	@Test
	public void tesetTableRander() {
		String result = tableRander(Clazz.class,"6","1","10");
		System.out.println(result);
	}
	
	@Test
	public void testAddStudent() {
		int result = cs.addStudent("3", "7");
		System.out.println(result);
	}
	@Test
	public void testGetClassDetail() {
		
		ClazzDetail classDetail = cs.getClassDetail("1");
		System.out.println(classDetail.getClazzFiles());
		System.out.println(classDetail.getHomeworks());
		System.out.println(classDetail.getStudents());
		System.out.println(classDetail.getTeacher());
		/*HashSet<Homework> hashSet = new HashSet<Homework>(classDetail.getHomeworks());
		System.out.println(hashSet);
		HashSet<Userinfo> hashSet1 = new HashSet<Userinfo>(classDetail.getStudents());
		System.out.println(hashSet1);*/
	}
	
	
	private <T>String tableRander(Class<T> claxx ,String teacheridStr, String page,String limit) {
		//
		System.out.println("进了表格渲染方法");
		Map<String,Object> map = null;
		String msg = "";
		int code = 0;
		if(claxx!=null&&!("".equals(claxx.toString()))) {
			if(claxx.equals(Clazz.class)) {
				
				 map = cs.listClazzByTeacherid(teacheridStr, page, limit);
			}else if(claxx.equals(Userinfo.class)) {
				map = cs.listClazzByTeacherid(teacheridStr, page, limit);
			}else {
				
			}
			
		}else {
			return null;
		}
		JSONObject json = new JSONObject();
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		//设置头部信息
		result.put("code", code);
		result.put("msg", msg);
		result.put("count", map.get("count"));
		Field[] declaredFields = claxx.getDeclaredFields(); //得到类字节码中的所有属性
		List<T>list = (List)map.get("list");
		for (T object : list) {
			//数据绑定
			for (Field field : declaredFields) { //遍历所有属性 serialVersionUID除外
				String propertyName = field.getName();
				if(!(propertyName.equals("serialVersionUID"))){
					if(propertyName.indexOf("state")<0) {
						String methodName = "get"+ propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
						System.out.println("方法名"+methodName);
						try {
							Method method = claxx.getMethod(methodName, null);
							Object m = method.invoke(object);
							System.out.println(m);
							json.put(propertyName, m);
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}else {
						String methodName = "get"+ propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
						try {
							Method method = claxx.getMethod(methodName, null);
							Integer state = (Integer)method.invoke(object, null);
							json.put(propertyName, state==1?"启用":"禁用");
							
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}
					
				}
			}
			
			jsons.add(json);
		}
		result.put("data", jsons);
		return result.toString();
	}

}
