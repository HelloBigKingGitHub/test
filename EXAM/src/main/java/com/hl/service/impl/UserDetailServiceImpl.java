package com.hl.service.impl;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.UserDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.UserSetBean;
import com.hl.mapper.UserDetailMapper;
import com.hl.service.UserDetailService;
import com.hl.service.UserService;
import com.hl.util.file.FileUploadUtil;
import com.hl.util.string.StringUtil;

@Service
public class UserDetailServiceImpl implements UserDetailService{
	
	
	@Autowired
	private UserDetailMapper userDetailMapper;

	@Autowired
	private UserService userService;
	@Override
	public boolean setUserDetail(UserSetBean userSetBean, Userinfo currentUser) {
		UserDetail userDetail = userSetBeanToUserDetail(userSetBean,currentUser);
		//1.更新数据库中的sysuer表中的usertruename字段
		boolean updateNameIsok = userService.updateUsertruename(userDetail.getUser());
		boolean setUserDetailIsok = false;
		//2.在userdetail表中插入用户详细信息，如果没有记录就是插入，如果用记录就是更新数据
		UserDetail userDetailTemp = existUserDetail(userDetail);
		if(userDetailTemp!=null&&userDetailTemp.getUdid()!=null) { //用户的详细信息已经存在
			setUserDetailIsok = updateUserDetail(userDetail);
		}else {//用户详细信息不存在
			setUserDetailIsok = insertUserDetail(userDetail);
		}
		
		return (updateNameIsok&&setUserDetailIsok);
	}

	

	@Override
	public boolean insertUserDetail(UserDetail userDetail) {
				return userDetailMapper.insertUserDetail(userDetail) > 0;
	}

	@Override
	public boolean updateUserDetail(UserDetail userDetail) {
		return userDetailMapper.updateUserDetail(userDetail) > 0;
	}

	@Override
	public UserDetail existUserDetail(UserDetail userDetail) {
		// TODO Auto-generated method stub
		return userDetailMapper.getUserDetail(userDetail);
	}
	
	
	




	@Override
	public boolean uploadUserIcon(MultipartFile file, HttpServletRequest request, Userinfo currentUser) {
		
		boolean isok = false;
		//步骤 1.的到当前对象，查询对象的头像是否存在。
		UserDetail userDetail = new UserDetail();
		userDetail.setUser(currentUser);
		userDetail = existUserDetail(userDetail);
		String oldIconUrl = userDetail.getIcon();//得到老的头像路径
		String UUIDFileName = FileUploadUtil.buildUUIDFileName(currentUser.getUsertruename());
		
		Map<String, String> uploadMessage = FileUploadUtil.upload(file, request, UUIDFileName);  //调用工具类上传文件
		String uploadPath = uploadMessage.get("uploadPath");  //文件上传的父文件夹
		String fileName = uploadMessage.get("fileName");
		
		//2.当前用户详细信息记录存在，调用更新操作，并且删除本地的原头像文件（防止图片文件过的占用空间）
		if (userDetail != null) {
			if (uploadMessage.get("msg").equals("成功")) {// 文件上传出成功,更新数据库用户详细信息中icon的数据
				userDetail.setIcon(uploadMessage.get("fileUrlTemp"));
				boolean updateIsOk = userDetailMapper.updateUserDetailIcon(userDetail);
				if (!updateIsOk) { // 如果数据库跟新不成功，就删除刚刚上传的文件。
					FileUploadUtil.removeLocalFile(fileName, uploadPath);
					isok = false;
				} else {
					if(oldIconUrl!=null&&!("".equals(oldIconUrl))) {
						
						isok = FileUploadUtil.removeLocalFile(oldIconUrl); // 调用工具类删除本地文件(老头像文件)
					}else {
						isok = true;
					}

				}
			} else {
				isok = false;
			}
		}
		
		return isok;
	}

	
	@Override
	public String getUserIcon(Userinfo currentUser) {
		
		return userDetailMapper.getUserIcon(currentUser);
	}

	/**
	 * 将当期用户和用户设置表单的数据转化为用户详细信息实体
	 * @param userSetBean
	 * @param currentUser
	 * @return
	 */
	private UserDetail userSetBeanToUserDetail(UserSetBean userSetBean, Userinfo currentUser) {
		UserDetail userDetail = new UserDetail();
		currentUser.setUsertruename(userSetBean.getUsername());
		userDetail.setUser(currentUser);
		userDetail.setEmail(userSetBean.getEmail());
		userDetail.setMotto(userSetBean.getMotto());
		userDetail.setSex(userSetBean.getSex());
		userDetail.setUcity(userSetBean.getCity());
		return userDetail;
	}



	
	@Override
	public UserDetail getUserDetailByUserid(String userid) {
		if(!StringUtil.isInteger(userid)) {
			return new  UserDetail();
		}
		int useridInt = Integer.parseInt(userid);
		UserDetail userDetail = new UserDetail();
		Userinfo user = new Userinfo();
		user.setUserid(useridInt);
		userDetail.setUser(user);
		return userDetailMapper.getUserDetail(userDetail);
	}




}
