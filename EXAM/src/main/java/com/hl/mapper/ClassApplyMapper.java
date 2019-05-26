package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.ClassApply;


/**
 * 有关数据库class_apply中的mapper层接口
 * @author admin
 *
 */
public interface ClassApplyMapper {

	/**
	 * 添加一条class_apply记录
	 * @param classid
	 * @param userid
	 * @return
	 */
	int insertClassApply(Integer classid, Integer userid);

	/**
	 * 
	 * <p>Title: listClassApplyByUserid</p>  
	 * <p>Description: </p> 
	 * <p>data:2019年5月4日 下午12:59:58 </p> 
	 * @param userid
	 * @return
	 */
	List<ClassApply> listClassApplyByUserid(Integer userid);

	/**
	 * 
	 * <p>Title: deleteApply</p>  
	 * <p>Description: 删除申请信息</p> 
	 * <p>data:2019年5月4日 下午4:21:29 </p> 
	 * @param applyuserInt
	 * @param classidInt
	 * @return
	 */
	int deleteApply(@Param("applyuser")int applyuserInt, @Param("classid")int classidInt);
	
	
	
	

}
