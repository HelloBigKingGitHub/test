package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Userinfo;
import com.hl.mapper.UserMapper;
import com.hl.service.UserService;

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



}
