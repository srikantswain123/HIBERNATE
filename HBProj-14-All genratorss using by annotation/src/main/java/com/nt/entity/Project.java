package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="PROJECT")
@DynamicInsert(value =true)
@DynamicUpdate(value=true)
public final class Project implements Serializable {
	//implicit generator
	/*
	 * @Id
	 * 
	 * @GenericGenerator(name="gen1",strategy = "sequence")
	 * 
	 * @GeneratedValue(generator = "gen1")
	 */
	@Id
	@GenericGenerator(name="gen1",strategy = "sequence",parameters =@Parameter(name="sequence_name",value="PID_SEQ"))
	@GeneratedValue(generator = "gen1")
	private Long pid;
	@Column(name = "pname")
	private String pname;
	@Column(name="teamMemeber")
	private Integer teamMember;
	@Column(name="compName")
	private String compName;
	
	
	
	public Long getPid() {
		return pid;
	}
	
	public String getPname() {
		return pname;
	}
	
	public Integer getTeamMember() {
		return teamMember;
	}
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
