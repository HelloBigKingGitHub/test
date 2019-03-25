package com.hl.mapper;

import java.util.List;
import java.util.Map;

import com.hl.entity.ChoseSubject;
import com.hl.entity.Paper;
import com.hl.entity.PaperDetail;
import com.hl.entity.Userinfo;

/**
 * 对试卷进行操作的到层
 * @author hl
 *
 */
public interface PaperMapper {
	/**
	 * 查询所有的试卷，并返回到一个list集合中
	 * @return 试卷集合
	 */
	List<Paper> listPaper();
	
	/**
	 * 根据试卷的id好查询出该试卷中的有的题目
	 * @param pid
	 * @return ChoseSubject的集合
	 */
	List<ChoseSubject> listChoseSubject(String pid);
	
	/**
	 *根据试卷的id号查询试卷的详细信息 
	 * @param pid
	 * @return PaperDetail 试卷的详细信息
	 */
	PaperDetail queryPaperDetailById(String pid);
	
	/**
	 * 跟新数据中试卷的详细信息
	 * @param paperDetail
	 * @return
	 */
	int updataPaperDetail (PaperDetail paperDetail);

	/**
	 * 根据条件进行查询，mapper.xml用到sql拼接
	 * @param select
	 * @return
	 */
	List<Userinfo> listPaperBySelect(Map<String, Object> select);

	/**
	 * 想数据库中paper表中插入一条数据，并返回该记录的id值
	 * @param paper
	 * @return 操作数
	 */
	int insertPaper(Paper paper);

	/**
	 * 向数据库paperdetail表中插入一条记录
	 * @param paperDetail
	 * @return 操作数
	 */
	int insertPaperDetail(PaperDetail paperDetail);

	/**
	 * 向paper_subject表中插入数据
	 * @param pid
	 * @param sid
	 * @return 操作数
	 */
	int insertPaperSubject(Map<String,Integer> pidSid);
	
	

}
