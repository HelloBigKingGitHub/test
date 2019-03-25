package com.hl.formbean;

/**
 * 选择题的页面表单数据分装类
 * @author hl
 *
 */
public class ChoseSubjectFormBean {
	private String sid;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	private String scontent; 
	private String sa;
	private String sb;
	private String sc;
	private String sd;
	private String skey;
	private String sstate;
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getSa() {
		return sa;
	}
	public void setSa(String sa) {
		this.sa = sa;
	}
	public String getSb() {
		return sb;
	}
	public void setSb(String sb) {
		this.sb = sb;
	}
	public String getSc() {
		return sc;
	}
	public void setSc(String sc) {
		this.sc = sc;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	public String getSstate() {
		return sstate;
	}
	public void setSstate(String sstate) {
		this.sstate = sstate;
	}
	@Override
	public String toString() {
		return "ChoseSubjectFormBean [sid=" + sid + ", scontent=" + scontent + ", sa=" + sa + ", sb=" + sb + ", sc="
				+ sc + ", sd=" + sd + ", skey=" + skey + ", sstate=" + sstate + "]";
	}
	
	
	

}
