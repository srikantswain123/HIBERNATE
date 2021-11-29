package com.nt.entity;

import java.io.Serializable;

public class Project_Composite implements Serializable{
	private ProgramerId id;
	private String projectName;
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
