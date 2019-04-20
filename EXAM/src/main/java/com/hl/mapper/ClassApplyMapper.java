package com.hl.mapper;

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
	
	
	
	

}
