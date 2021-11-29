package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
@Entity
public class Person_Info implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@Column(length=20)
	@Type(type="string")
	private String pname;
	//@Column
	private LocalDateTime dob;
	//@Column
	private LocalDate doj;
	//@Column
	private LocalDateTime dom;
	
	public Integer getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public LocalDateTime getDom() {
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

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public void setDom(LocalDateTime dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "Person_Info [pid=" + pid + ", pname=" + pname + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
	

}
