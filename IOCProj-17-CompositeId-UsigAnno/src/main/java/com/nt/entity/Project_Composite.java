package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
@Entity
@Table(name="PROJECT_COMPOSITE")
public class Project_Composite implements Serializable{
	@EmbeddedId
	private ProgramerId id;
	@Column(name="PROJECTNAME",length=20)
	@Type(type="string")
	private String projectName;
	@Column(name="COMPANY",length=20)
	@Type(type="string")
	private String company;
	public ProgramerId getId() {
		return id;
	}
	public String getProjectName() {
		return projectName;
	}
	public String getCompany() {
		return company;
	}
	public void setId(ProgramerId id) {
		this.id = id;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Project_Composite [id=" + id + ", projectName=" + projectName + ", company=" + company + "]";
	}
	

}
