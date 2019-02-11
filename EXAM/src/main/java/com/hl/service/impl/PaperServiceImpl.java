package com.hl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.Paper;
import com.hl.entity.PaperDetail;
import com.hl.mapper.PaperMapper;
import com.hl.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService{

	@Autowired
	private PaperMapper mapper;
	@Override
	public List<Paper> PaperList() {
		//System.out.println(mapper.listPaper().get(0).getPname());
		return mapper.listPaper();
	}
	@Override
	public boolean updataPaperDetail(PaperDetail paperDetail) {
		// TODO Auto-generated method stub
		return mapper.updataPaperDetail(paperDetail)>0;
	}

}
