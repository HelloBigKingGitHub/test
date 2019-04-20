package com.hl.util.date;

import java.text.SimpleDateFormat;

/**
 * 
 * @author admin
 *
 */
public class SimpleDateFormatUtil {
	private static SimpleDateFormat sdf = null;
	private SimpleDateFormatUtil() {
		
	}
	
	public static SimpleDateFormat getInstance() {  //双判断线程安全单例模式
		if(sdf == null) {
			synchronized (SimpleDateFormatUtil.class) {
				if(sdf == null) {
					sdf = new SimpleDateFormat("yyyy-MM-dd");
				}
			}
		}
		return sdf;
	}

}
