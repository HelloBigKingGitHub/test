package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.ClassApply;
import com.hl.entity.Userinfo;
import com.hl.mapper.ClassApplyMapper;
import com.hl.service.ClassApplyService;
import com.hl.service.ClazzService;
import com.hl.util.string.StringUtil;

@Service
public class ClassApplyServiceImpl implements ClassApplyService{
	
	private Logger logger = Logger.getLogger(ClassApplyServiceImpl.class);

	@Autowired
	private ClassApplyMapper classApplyMapper;
	@Autowired
	private ClazzService classService;
	@Override
	public boolean insertClassApply(Integer classid, Integer userid) {
		
		return classApplyMapper.insertClassApply(classid, userid) > 0;
	}
	
	
	@Override
	public Map<String, Object> listUserAllClassApply(String pageStr, String limitStr, Userinfo user) {
		if(user.getUserid()==null||pageStr==null||limitStr==null) {
			return null;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<ClassApply> apply = classApplyMapper.listClassApplyByUserid(user.getUserid());
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", apply);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}


	@Override
	public boolean agreeStudentJoinClass(String applyuser, String classid, String idea) {
		if(!StringUtil.isInteger(classid) || !StringUtil.isInteger(applyuser) || idea == null || "".equals(idea)) {
			return false;
		}
		logger.info("agreeStudentJoinClass-->classid="+classid+"applyuer="+applyuser+"idea"+idea);
		int applyuserInt = Integer.parseInt(applyuser);
		int classidInt = Integer.parseInt(classid);
		if(idea.equals("agree")) { //同意该学生加入班级
			int addCede = classService.addStudent(classid, applyuser);
			if(addCede == 1) { //添加成功
				return classApplyMapper.deleteApply(applyuserInt,classidInt) > 0; //删除申请信息
			}else {
				return false;
			}
		}else {
			return classApplyMapper.deleteApply(applyuserInt,classidInt) > 0; //删除申请信息
		}
	}

}
