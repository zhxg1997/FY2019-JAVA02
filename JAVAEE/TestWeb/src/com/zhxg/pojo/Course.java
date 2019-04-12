package com.zhxg.pojo;

import java.io.Serializable;


public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int cid;
	public String cname;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Course(int cid,String cname){
		this.cid = cid;
		this.cname = cname;
	}
}
