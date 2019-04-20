package com.hl.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hl.entity.ErrorSubject;
import com.hl.entity.Subject;
import com.hl.entity.Userinfo;

/**
 * 有关错题集的服务类
 * @author hl
 *
 */
public interface ErrorSubjectService {
	
	/**
	 * 增添一条错题信息
	 * @param errorSubject
	 * @return 执行成功则返回true 反之则反
	 */
	boolean addErrorSubject (ErrorSubject errorSubject);
	
	/**
	 * 判断错题信息是否已经存在
	 * @param errorSubject 根据id判断和错误答案，就算是同一个题目不同的答案也要算是不同的错题
	 * @return 如果错题信息存在就返回改错题
	 */
	ErrorSubject ErrorSubjectIsExist(ErrorSubject errorSubject);
	
	/**
	 * 查询所有的错题信息
	 * @return list集合
	 */
	List<ErrorSubject> listErrorSubject();
	
	/**
	 * 分页查询所有的错题信息
	 * @param pageNum当前页的页面数，pageSize 分页的大小
	 * @return Map集合存放页面的相关信息
	 */
	Map<String,Object> listErrorSubjectPage(Integer pageNum,Integer pageSize);
	
	/**
	 * 查询做错着题的所有学生
	 * @param subject
	 * @return 学生信息 集合
	 */
	Set<Userinfo> queryUserOfErrorSubject(Subject subject);

	/**
	 * <p>Title: userGetErrorSubject</p>  
	 * <p>Description:分页查询出某个学生的所有错题信息 </p> 
	 * <p>data:2019年4月14日 下午4:20:47 </p> 
	 * @param limit
	 * @param page
	 * @param scontent
	 * @param user
	 * @return
	 */
	 Map<String,Object> getErrorSubjectByUser(String limit, String page, String scontent, Userinfo user);

	 /**
	  * <p>Title: userDeleteErrorSubject</p>  
	  * <p>Description: 学生用户删除错题记录</p> 
	  * <p>data:2019年4月14日 下午10:22:07 </p> 
	  * @param user
	  * @param esid
	  * @return
	  */
	boolean userDeleteErrorSubject(Userinfo user, String esid);
	

}
