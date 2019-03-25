package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.UserDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.UserSetBean;
import com.hl.mapper.UserMapper;
import com.hl.service.UserService;
import com.hl.util.md5.UserPasswordMD5;

@Service
public class UserinfoServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	public List<Userinfo> listUserinfo() {
		return mapper.listUserinfo();
	}

	@Override
	public Map<String,Object> listPageUserinfo(Integer pageNum, Integer pageSize) {
		//开始进行分页，分页方法不是对mybatis进行入侵，而是增强了mybatis的执行方法
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Userinfo> list = mapper.listUserinfo();
		Long count = page.getTotal();
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("list", list);
		result.put("count", count);
		return result;
		
	}
	
	

	@Override
	public boolean userRegister(Userinfo userinfo) {
		if(mapper.userIsExist(userinfo)!=null) {//先判断用户是否已经存在
			return false;
		}else {
			return mapper.insertUserinfo(userinfo)>0;
		}
		
	}

	@Override
	public Userinfo userLogin(Userinfo userinfo) {
          return mapper.userIsExist(userinfo);
	}

	@Override
	public Map<String, Object> listStudent(String pageStr, String limitStr) {
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Userinfo> list = mapper.listUserinfoByRoleId(1);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public List<Userinfo> listTeacher() {
		return mapper.listUserinfoByRoleId(2);
	}
	
	@Override
	public boolean updateUsertruename(Userinfo user) {
		
		return mapper.updateUsertruename(user)>0;
	}

	@Override
	public String resetUserPassword(String nowpass, String pass, Userinfo user) {
		String pwd = user.getUserpwd();//得到当前用户进行过MD5加密后的密码
		Userinfo userTemp = new Userinfo(); //创建一个中间变量，先不改变session中的currentUser的中。
		userTemp.setUserpwd(nowpass);
		userTemp.setUserid(user.getUserid());
		userTemp = UserPasswordMD5.userPasswordMD5(userTemp);//进行MD5加密
		System.out.println("currentUserPwd="+pwd);
		System.out.println("userTempPwd="+userTemp.getUserpwd());
		if(!pwd.equals(userTemp.getUserpwd())) { //表单输入的密码与数据库中的密码不一致，返回false
			return "";
		}
		userTemp.setUserpwd(pass);//重置密码
		userTemp = UserPasswordMD5.userPasswordMD5(userTemp); //将新密码进行MD5加密
		
		int isok =  mapper.updateUserpwd(userTemp); //将新密码加入更新到数据库中
		if(isok > 0) { //更新成功
			//user.setUserpwd(userTemp.getUserpwd()); //修改session中当前用户的密码值，（提供连续修改的功能）
			return userTemp.getUserpwd();
		}else {
			return "";
		}
	}

	
}
