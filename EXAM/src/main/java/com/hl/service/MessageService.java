package com.hl.service;

import java.util.Map;

import com.hl.entity.Message;
import com.hl.entity.Userinfo;

/**
 * 消息message的业务服务层
 * @author hl
 *
 */
public interface MessageService {
	
	/**
	 * 添加一条消息记录
	 * @param message
	 * @return
	 */
	Message insertMessage(Message message);

	/**
	 * 查询出发送的所有消息（分页）
	 * @param sendUser
	 * @return
	 */
	Map<String, Object> getSendMessage(Userinfo sendUser,String pageStr, String limitStr);
	
	/**
	 * 查询出接受的所有消息
	 * @param sendUser
	 * @return
	 */
	Map<String, Object> getReceiveMessage(Userinfo receiveUser,String pageStr, String limitStr);

	/**
	 * 根据消息编号的得到消息
	 * @param messageid
	 * @return
	 */
	Message getMessageByMessageid(String messageid);
	
	/**
	 * 根据消息编号修改消息状态值
	 * @param messageid
	 * @return
	 */
	boolean updateMessageMstateByMessage(String messageid);

	/**
	 * 判断用户是否存在未读短信
	 * @param userinfo
	 * @return
	 */
	boolean exsitNotReadedMessage(Userinfo userinfo);

	/**
	 * 发送message给指定的用户
	 * @param userinfo 发送方用户
	 * @param mtitle message标题
	 * @param msg  message内容
	 * @param userid 接受方id
	 * @return
	 */
	boolean sendMessage(Userinfo userinfo, String mtitle, String msg, String userid);
	
}
