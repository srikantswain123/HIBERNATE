package com.nt.entity;

import java.io.Serializable;

import lombok.Data;


public class MobileCustomer implements Serializable {

	private Integer cno;
	private Long mobileNo;
	private String callerTune;
	private Integer version_count;
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCallerTune() {
		return callerTune;
	}
	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}
	public Integer getVersion_count() {
		return version_count;
	}
	public void setVersion_count(Integer version_count) {
		this.version_count = version_count;
	}
	@Override
	public String toString() {
		return "MobileCustomer [cno=" + cno + ", mobileNo=" + mobileNo + ", callerTune=" + callerTune
				+ ", version_count=" + version_count + "]";
	}

	
}
