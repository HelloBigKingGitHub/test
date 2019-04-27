package com.hl.entity;

import java.io.Serializable;
import java.sql.Date;

import com.hl.util.date.SimpleDateFormatUtil;

/**
 * 
 * <p>Title: PostBar</p>  
 * <p>Description: 贴纸实体类</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
public class PostBar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8535067973322575815L;
	
	private Integer pbid;
	private Date questime;      //发帖时间
	private Integer quescount;  //回答次数
	private String quescontent; //发帖内容
	private String tags;        //标签
	private String questitle;   //标题 
	private Integer liulancount;//浏览次数
	private Date liulantime;     //最后一次浏览时间
	private Integer reward;      //赏金
	private Integer userid;      //发帖用户
	public Integer getPbid() {
		return pbid;
	}
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
	public String getQuestime() {
		return SimpleDateFormatUtil.getInstance().format(questime);
	}
	public void setQuestime(Date questime) {
		this.questime = questime;
	}
	public Integer getQuescount() {
		return quescount;
	}
	public void setQuescount(Integer quescount) {
		this.quescount = quescount;
	}
	public String getQuescontent() {
		return quescontent;
	}
	public void setQuescontent(String quescontent) {
		this.quescontent = quescontent;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getQuestitle() {
		return questitle;
	}
	public void setQuestitle(String questitle) {
		this.questitle = questitle;
	}

	public Integer getLiulancount() {
		return liulancount;
	}
	public void setLiulancount(Integer liulancount) {
		this.liulancount = liulancount;
	}
	public String getLiulantime() {
		
		return SimpleDateFormatUtil.getInstance().format(liulantime);
	}
	public void setLiulantime(Date liulantime) {
		this.liulantime = liulantime;
	}
	public Integer getReward() {
		return reward;
	}
	public void setReward(Integer reward) {
		this.reward = reward;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "PostBar [pbid=" + pbid + ", questime=" + questime + ", quescount=" + quescount + ", quescontent="
				+ quescontent + ", tags=" + tags + ", questitle=" + questitle + ", liiulancount=" + liulancount
				+ ", liulantime=" + liulantime + ", reward=" + reward + ", userid=" + userid + "]";
	}
	
	
}
