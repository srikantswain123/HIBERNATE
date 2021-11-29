package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@Table(name="PROJECT")
@DynamicInsert(value =true)
@DynamicUpdate(value=true)
public final class Project implements Serializable {
	@Id
	/*
	 * @SequenceGenerator(name="PID_SEQ",allocationSize =12,initialValue = 10)  //using for sequence in oracle
	 * 
	 * @GeneratedValue(generator = "PID_SEQ")
	 */
	//-----------------------------------------------------------------------
	//@GeneratedValue(strategy = GenerationType.IDENTITY)  //using for mysql
	//-------------------------------------------------------------
	//custom table jpa generator it is like hilo kind of thing
	
	 /* @TableGenerator(name="tab_seqqqqq",pkColumnName = "pid_col", pkColumnValue =
	  "pid_val", valueColumnName ="val_col", allocationSize = 10, initialValue =         
	  20, table = "tab_gen")
	  
	  @GeneratedValue(generator = "tab_seqqqqq",strategy = GenerationType.TABLE)*/
	 
	//-------------------------------------------------------------------
	//@GeneratedValue(strategy = GenerationType.TABLE)  //for default table generator
	//------------------------------------------------------------------
	//@GeneratedValue(strategy = GenerationType.AUTO)   // it for oracle and create default sequence
	//--------------------------------------------------------
	//for using auto generator  using with custom sequence
	/*
	 * @SequenceGenerator(name = "auto_seq",allocationSize = 5,initialValue = 10)
	 * 
	 * @GeneratedValue(generator = "auto_seq",strategy = GenerationType.AUTO)
	 */
	//-----------------------------------------------For Mysql it creates Auto Table Generator
	@GeneratedValue(strategy = GenerationType.AUTO)
	
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
