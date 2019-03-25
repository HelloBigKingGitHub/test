package com.hl.util.ui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 前端页面表格的工具类
 * @author hl
 *
 */
public class TableUtil {
	
	/**
	 * 根据传输过来的数据转换成layui数据表格能个接受的数剧格式，完成对表格的渲染
	 * @param claxx
	 * @param map
	 * @param listName
	 * @return
	 */
	public static <T>String tableRander(Class<T> claxx ,Map<String,Object>map, String listName) {
		//System.out.println("进了表格渲染方法");
		String msg = "";
		int code = 0;
		JSONObject json = new JSONObject();
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		//设置头部信息
		result.put("code", code);
		result.put("msg", msg);
		result.put("count", map.get("count"));
		Class<? super T> superclass = claxx.getSuperclass(); //得到类的父类
		Field[] declaredFields = claxx.getDeclaredFields(); //得到类字节码中的所有属性
		List<Field> fieldList = new ArrayList<Field>(Arrays.asList(declaredFields));
		if(!superclass.getName().equals(Object.class.getName())) { //判断父类不是Object
			Field[] superclassDeclaredFields = superclass.getDeclaredFields();
			fieldList.addAll(Arrays.asList(superclassDeclaredFields)); //把父类属性也添加进属性数组里面
		}
		
		
		List<T>list = (List)map.get(listName);
		for (T object : list) {
			//数据绑定
			for (Field field : fieldList) { //遍历所有属性 serialVersionUID除外
				String propertyName = field.getName();
				if(!(propertyName.equals("serialVersionUID"))){
					if(propertyName.indexOf("state")<0) {
						//propertyName.indexOf("state")<0;
						String methodName = "get"+ propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
						try {
							Method method = claxx.getMethod(methodName, null);
							json.put(propertyName, method.invoke(object));
						} catch (NoSuchMethodException | SecurityException | IllegalAccessException
								| IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
					}else {
						String methodName = "get"+ propertyName.substring(0, 1).toUpperCase()+propertyName.substring(1);
						try {
							Method method = claxx.getMethod(methodName, null);
							Integer state = (Integer)method.invoke(object);
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
