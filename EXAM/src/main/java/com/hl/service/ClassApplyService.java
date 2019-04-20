package com.hl.service;

/**
 * 班级申请服务的接口类
 * @author hl
 *
 */
public interface ClassApplyService {
	
	/**
	 * 添加申请信息
	 * @param classid
	 * @param userid
	 * @return
	 */
	public boolean insertClassApply(Integer classid, Integer userid);

}
