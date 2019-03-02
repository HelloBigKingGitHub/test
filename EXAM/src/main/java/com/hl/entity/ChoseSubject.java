package com.hl.entity;

import java.io.Serializable;

/**
 * 试题的实体类（选择题），后续可能扩充其他的题型
 * @author hl
 *
 */
public class ChoseSubject extends Subject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sa;
	private String sb;
	private String sc;
	private String sd;
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
	@Override
	public String toString() {
		return super.toString()+"ChoseSubject [sa=" + sa + ", sb=" + sb + ", sc=" + sc + ", sd=" + sd + "]";
	}
	
}
