package com.hl.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.UserDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.UserSetBean;

/**
 * 用户详细信息的服务层
 * @author hl
 *
 */
public interface UserDetailService {


	/**
	 * 插入用户详细数据 
	 * @param userDetail
	 * @return
	 */
	boolean insertUserDetail(UserDetail userDetail);
	
	/**
	 * 更新用户详细信息
	 * @param userDetail
	 * @return
	 */
	boolean updateUserDetail(UserDetail userDetail);
	
	/**
	 * 判断该用户详细信息是否存在
	 * @param userDetail
	 * @return
	 */
	UserDetail existUserDetail(UserDetail userDetail);
	
	/**
	 * 用户设置自己的详细信息
	 * @param userSetBean
	 * @return
	 */
	boolean setUserDetail(UserSetBean userSetBean,Userinfo currentUser);

	/**
	 * 给用户添加头像信息
	 * @param file 上传的文件
	 * @param request  request请求对象
	 * @param currentUser  当前用户
	 * @return 布尔值
	 */
	boolean uploadUserIcon(MultipartFile file, HttpServletRequest request, Userinfo currentUser);

	/**
	 * 通过当前用户的到用户的头像信息
	 * @param currentUser
	 * @return 头像的访问路径
	 */
	String getUserIcon(Userinfo currentUser);

	
	/**
	 * 
	 * <p>Title: getUserDetailByUserid</p>  
	 * <p>Description: 得到用户的详细信息</p> 
	 * <p>data:2019年4月27日 下午4:20:22 </p> 
	 * @param userid
	 * @return
	 */
	UserDetail getUserDetailByUserid(String userid);
}
