package com.hl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.Score;
import com.hl.mapper.ScoreMapper;
import com.hl.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public boolean insertScore(Score score) {
		
		return scoreMapper.insertScore(score)>0;
	}

}
