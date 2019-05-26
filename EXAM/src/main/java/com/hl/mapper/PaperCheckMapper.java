package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.PaperCheck;
import com.hl.entity.PaperDetail;

/**
 * paper_check表的mapper层接口
 * @author 
 *
 */
public interface PaperCheckMapper {

	/**
	 * 增加一条审查记录
	 * @param paperCheck
	 * @return 操作数
	 */
	int insertPaperCheck(PaperCheck paperCheck);
	

	/**
	 * 根据教师编号查询出所有该教师需要审查的试卷
	 * @param teacher
	 * @return
	 */
	List<PaperDetail> listCheckPaperByTeacherId(Integer teacher);


	/**
	 * 
	 * <p>Title: deleteCheckPaper</p>  
	 * <p>Description: 删除指定的审查记录</p> 
	 * <p>data:2019年5月2日 下午4:07:54 </p> 
	 * @param pidInt
	 * @param checkteacheridInt
	 * @return
	 */
	int deleteCheckPaper(@Param("pid")int pidInt, @Param("checkteacherid")int checkteacheridInt);


	/**
	 * 
	 * <p>Title: getCheckRest</p>  
	 * <p>Description: 得到试卷的审查结果</p> 
	 * <p>data:2019年5月2日 下午4:34:53 </p> 
	 * @param pidInt
	 * @return
	 */
	List<String> getCheckRest(@Param("pid")int pidInt);


	/**
	 * 
	 * <p>Title: update</p>  
	 * <p>Description: 更新试卷审查表中</p> 
	 * <p>data:2019年5月2日 下午5:27:33 </p> 
	 * @param pidInt
	 * @param userid
	 * @param checkcontent
	 * @return
	 */
	int update(@Param("pid")int pidInt, @Param("checkteacherid")int userid, @Param("checkcontent")String checkcontent);

}
