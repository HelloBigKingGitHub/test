package com.hl.util;

import java.lang.reflect.Field;

import com.hl.entity.Clazz;

public class TestReflect {
	
	public static void main(String[] args) {
		//System.out.println(Clazz.class);
		test(Clazz.class);
	}
	
	private static <T> void test (Class<T> claxx) {
		if(claxx.equals(Clazz.class)) {
			System.out.println("进来了");
			try {
				T t = claxx.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Field[] fields = claxx.getDeclaredFields();
			System.out.println(fields.length);
			for (Field field : fields) {
				System.out.println(field.getName()+"的属性类型"+field.getGenericType());
			}
		}else {
			System.out.println("no");
		}
	}

}
