package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;
@Entity
@DynamicInsert(true)
@Table(name="PROJECT")
@Proxy(lazy = true,proxyClass = Iproject.class)
public final class Project implements Serializable,Iproject {
	private Long pid;
	private String pname;
	private Integer teamMember;
	private String compName;
	
	
	@Id
	@Column(name="PID",nullable = false,length = 10,unique = true)
	@Type(type="long")
	public Long getPid() {
		return pid;
	}
	@Column(name="PNAME",length = 20)
	@Type(type = "string")
	public String getPname() {
		return pname;
	}
	@Column(name="TEAMMEMBER",length=20)
	public Integer getTeamMember() {
		return teamMember;
	}
	@Column(name="COMPNAME",nullable = false,length = 20)
	@Type(type = "string")
	//@Transient
	public String getCompName() {
		return compName;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setTeamMember(Integer teamMember) {
		this.teamMember = teamMember;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", teamMember=" + teamMember + ", compName=" + compName
				+ "]";
	}
	
	
	

}
