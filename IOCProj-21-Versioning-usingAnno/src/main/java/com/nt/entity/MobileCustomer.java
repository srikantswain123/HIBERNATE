package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.Type;


@Entity
public class MobileCustomer implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cno;
@Column(length=20)
@Type(type="long")
	private Long mobileNo;
@Column(length=30)
@Type(type="string")
	private String callerTune;
@Version
@Type(type ="int")
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
	return "MobileCustomer [cno=" + cno + ", mobileNo=" + mobileNo + ", callerTune=" + callerTune + ", version_count="
			+ version_count + "]";
}



}
