package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;




@Entity
@NamedNativeQuery(name = "insert_record",query = "INSERT INTO INSURANCEPOLICY VALUES(?,?,?,?,?)")
@NamedNativeQuery(name = "delete_record",query = "delete from INSURANCEPOLICY where policyid=:id",resultClass = InsurancePolicy.class)
public  class InsurancePolicy implements Serializable {
	@Id
	private Long policyId;
    private String policyName;
    private String policyType;
    private String company;
    private Integer tenure;
	public Long getPolicyId() {
		return policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public String getCompany() {
		return company;
	}
	public Integer getTenure() {
		return tenure;
	}
	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
	
}
