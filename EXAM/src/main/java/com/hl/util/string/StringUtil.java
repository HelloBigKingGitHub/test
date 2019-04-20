package com.hl.util.string;

import java.util.regex.Pattern;

/**
 * 自定义的字符创工具类
 * @author admin
 *
 */
public class StringUtil {
	
	/**
	 * 判断一个字符创是否有数字字符组成，主要用于前端传递过来的id判断
	 * @param str
	 * @return
	 */
	  public static boolean isInteger(String str) { 
		  if(str == null || "".equals(str)) {
			  return false;
		  }
	        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	        return pattern.matcher(str).matches();  
	  }
}
