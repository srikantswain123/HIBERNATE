package com.nt.entity;

import java.io.Serializable;

public class ProgramerId implements Serializable {
	private Integer pid;
	private Integer ProjectId;
	public Integer getPid() {
		return pid;
	}
	public Integer getProjectId() {
		return ProjectId;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setProjectId(Integer projectId) {
		ProjectId = projectId;
	}
	@Override
	public String toString() {
		return "ProgramerId [pid=" + pid + ", ProjectId=" + ProjectId + "]";
	}
	

}
