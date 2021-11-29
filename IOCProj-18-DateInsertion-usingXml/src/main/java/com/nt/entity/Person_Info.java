package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Person_Info implements Serializable {
	private Integer pid;
	private String pname;
	private LocalDateTime dob;
	private LocalDateTime doj;
	private LocalDate dom;
	
	public Integer getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public LocalDateTime getDoj() {
		return doj;
	}

	public LocalDate getDom() {
		return dom;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}

	public void setDom(LocalDate dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "Person_Info [pid=" + pid + ", pname=" + pname + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
	

}
