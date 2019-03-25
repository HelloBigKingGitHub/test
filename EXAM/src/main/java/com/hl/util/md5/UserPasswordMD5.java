package com.hl.util.md5;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;

import com.hl.entity.Userinfo;

/**
 * 负责给userinfo对象中的密码password进行加密
 * @author admin
 *
 */
public class UserPasswordMD5 {
	
	private static MessageDigest md5 ; 
	//获取MD5 加密算法
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 给用户的密码进行加密，然后返回该用户
	 * @param userinfo
	 * @return
	 */
	public static Userinfo userPasswordMD5(Userinfo userinfo) {
		//密码需要进行md5加密
		try {
			userinfo.setUserpwd(Base64.encodeBase64String(md5.digest(userinfo.getUserpwd().getBytes("utf-8"))));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userinfo;
		
	}

}
