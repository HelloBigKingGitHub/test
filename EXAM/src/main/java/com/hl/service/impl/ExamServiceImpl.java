package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.ChoseSubject;
import com.hl.entity.ErrorSubject;
import com.hl.entity.PaperDetail;
import com.hl.entity.Score;
import com.hl.entity.Userinfo;
import com.hl.mapper.PaperMapper;
import com.hl.service.ErrorSubjectService;
import com.hl.service.ExamService;
import com.hl.service.PaperService;
import com.hl.service.ScoreService;
import com.hl.service.SubjectService;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	private PaperMapper mapper;
	@Autowired
	private ErrorSubjectService errorSubjectService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private PaperService paperService;

	@Override
	public Map<PaperDetail, List<ChoseSubject>> startTest(String pid) {
		Map<PaperDetail, List<ChoseSubject>> map = new HashMap<PaperDetail, List<ChoseSubject>>();
		map.put(mapper.queryPaperDetailById(pid), mapper.listChoseSubject(pid));
		return map;
	}

	@Override
	public boolean submitTest(Map<String, Object> answerMap) {
		boolean flag1= false, flag2= false, flag3 = false;//标志位
		double right = 0;//正确的题目数
		double error = 0;//出窝的题目数
		double score = 0.0d;
		ErrorSubject errorSubject = new ErrorSubject(); //错题对象
		Score userScore = new Score();//用户的成绩单对象
		PaperDetail paperDetail = new PaperDetail();//试卷详细信息对象 
		//根据answerMap得到试卷的Id和提交试卷上的用户
		String pid = (String)answerMap.get("pid");
		Userinfo crruentUser = (Userinfo)answerMap.get("crruentUser");
		Integer userid = crruentUser.getUserid();
		//1.获得当前试卷的所有问题并且对答案进行对比 
		Map<PaperDetail, List<ChoseSubject>> map = startTest(pid); //内部调用startTest方法得到试卷的全部题目
		Set<PaperDetail> keySet = map.keySet();
		List<ChoseSubject> list = null;
		for (PaperDetail paperDetailTemp : keySet) {
			list = map.get(paperDetailTemp);
			paperDetail = paperDetailTemp;
		}
		//2.将错误的题目构成错题集（errorsubject）,遍历集合list，挨个比较答案
		int oldTestCount = 0;
		for (ChoseSubject choseSubject : list) {
			String answer = (String)answerMap.get(choseSubject.getSid()+"");
			//将题目的测试次数进行修改（+1）
			oldTestCount = choseSubject.getTestcount();
			choseSubject.setTestcount(oldTestCount + 1);
			subjectService.updataChoseSubject(choseSubject);
			if(answer!=null&&answer.equals(choseSubject.getSkey())) {
				right++;
			}else {
				error++;
				//此时answer是错误答案，构建错题集
				errorSubject.setEkey(answer);
				errorSubject.setSubject(choseSubject);
				errorSubject.setUserid(userid);
				//调用错题的服务层 增加一条错题信息
				ErrorSubject errorSubjectTemp;
				//errorSubjectTemp = errorSubjectService.ErrorSubjectIsExist(errorSubject,crruentUser);
				if(true||errorSubjectTemp==null) {//判断该错题信息不存在，如果不存在才往错题信息中添加记录
					flag1 = errorSubjectService.addErrorSubject(errorSubject);					
				}
			}
		}
		//3.构建用户与试卷的成绩单（user_paper）keySet
		score = paperDetail.getPaggregatescore()*(right/(right+error));
		userScore.setPid(Integer.parseInt(pid));
		userScore.setUserid(userid);
		userScore.setScore(score);
		flag2 = scoreService.insertScore(userScore);
		//4.获得当前试卷的详细信息（修改测试次数和平均成绩）
		Integer testdegree = paperDetail.getTestdegree();
		double aveScoreTemp = paperDetail.getAvescore();
		System.out.println("考试次数="+testdegree+"，平均分="+aveScoreTemp);
		double aveScore = 0.0;
		paperDetail.setTestdegree(testdegree+1);
		double newSumScore = testdegree*aveScoreTemp+score;
		System.out.println("所有考试的分数之和="+newSumScore);
		aveScore = newSumScore / paperDetail.getTestdegree();
        System.out.println(aveScore);
		paperDetail.setAvescore(aveScore);
		flag3 = paperService.updataPaperDetail(paperDetail);
		
		return flag1&&flag2&&flag3;
	}
	
	

}
