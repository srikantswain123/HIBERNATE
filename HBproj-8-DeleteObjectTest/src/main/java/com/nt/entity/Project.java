package com.nt.entity;

public class Project {
	private int projid;
	private String projName;
	private int employes;
	public int getProjid() {
		return projid;
	}
	public String getProjName() {
		return projName;
	}
	public int getEmployes() {
		return employes;
	}
	public void setProjid(int projid) {
		this.projid = projid;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public void setEmployes(int employes) {
		this.employes = employes;
	}
	@Override
	public String toString() {
		return "Project [projid=" + projid + ", projName=" + projName + ", employes=" + employes + "]";
	}
	
	
	

}
