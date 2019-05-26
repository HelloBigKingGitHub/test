package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Paper;
import com.hl.entity.PaperCheck;
import com.hl.entity.PaperDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.PaperFormBean;
import com.hl.mapper.PaperMapper;
import com.hl.service.PaperCheckService;
import com.hl.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService{

	@Autowired
	private PaperMapper mapper;
	@Autowired
	private PaperCheckService paperCheckService;
	@Override
	public List<Paper> PaperList() {
		//System.out.println(mapper.listPaper().get(0).getPname());
		return mapper.listPaper();
	}
	@Override
	public boolean updataPaperDetail(PaperDetail paperDetail) {
		return mapper.updataPaperDetail(paperDetail)>0;
	}
	@Override
	public Map<String, Object> listPaper(String pageStr, String limit, String teacherid, String papername,
			String paperid) {
		Integer teacher = null;
		Integer paper  = null;
		if(teacherid!=null&&!("".equals(teacherid))) {
			
			teacher = Integer.parseInt(teacherid);
		}
		if(paperid!=null&&!("".equals(paperid))){
			
			paper = Integer.parseInt(paperid);
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limit);
		Map<String,Object> result = new HashMap<>();
		Map<String,Object> select = new HashMap<>(); //将查询条件封装进一个map中
		select.put("teacherid", teacher);
		select.put("paperid", paper);
		select.put("papername", papername!=null?papername.trim():(papername = ""));
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Userinfo> list = mapper.listPaperBySelect(select);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	@Override
	public boolean addPaper(PaperFormBean paperFormBean, Userinfo currentUser) throws Exception {
		
		boolean InsertPSIsOk = true; //判断插入paper_subject 的数据是否成功
		//1.创建paper对象
		Paper paper = new Paper();
		paper.setPname(paperFormBean.getPname());
		paper.setTeacherid(currentUser.getUserid());
		//2.创建paperDetail对象
		PaperDetail paperDetail = new PaperDetail();
		paperDetail.setPaggregatescore(Double.parseDouble(paperFormBean.getPaggregatescore()));
		paperDetail.setPtime(paperFormBean.getPtime());
		//3.插入paper数据
		int paperInsertIsOk = mapper.insertPaper(paper);
		paperDetail.setPaper(paper);
		//4.插入paperDetail数据
		int paperDetailInsertIsOk =  mapper.insertPaperDetail(paperDetail);
		//5.插入paper_subject数据
		Integer pid = paper.getPid();
		Map<String,Integer> pidSid = new HashMap<>();
		pidSid.put("pid", pid);
		Integer sid = null;
		List<String> sids = paperFormBean.getSubjectidList();
		for (String string : sids) {
			sid = Integer.parseInt(string);
			pidSid.put("sid", sid);
			if(mapper.insertPaperSubject(pidSid)<=0) { //还是尽量封装成对象，这样效率比较低
				InsertPSIsOk = false;
			}
		}
		//6.插入审查表数据
		PaperCheck paperCheck = new PaperCheck();
		Userinfo checkTeacher = new Userinfo();
		checkTeacher.setUserid(Integer.parseInt(paperFormBean.getCheckteacher()));
		paperCheck.setCheckteacher(checkTeacher);
		paperCheck.setPaper(paper);
		boolean insertPaperCheckIsOk = paperCheckService.insertPaperCheck(paperCheck);
		if(!insertPaperCheckIsOk||(!InsertPSIsOk)||(paperDetailInsertIsOk<=0)||(paperInsertIsOk<=0)) {//任一条件不满足抛出异常，数据库回滚
			throw new Exception();
		}
		return true;
	}
	
	
	@Override
	public void updatePaperState(int i, int pid) {
		mapper.updatePaperState(i,pid);
		
	}
	
}
