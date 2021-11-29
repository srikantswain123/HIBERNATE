package com.nt.entity;

import java.io.Serializable;

public final class InsurancePolicy implements Serializable {
	private Long policyId;
    private String policyName;
    private String policyType;
    private String company;
    private String tenure;
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
	public String getTenure() {
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
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	/*@Override
	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}*/
	
}
