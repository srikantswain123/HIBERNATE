package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "PREMIUM_INSURANCEPOLICY")
@NamedQuery(name = "HQL_TRANSFER_QUERY", query = "INSERT INTO com.nt.entity.PremiumInsurancePolicy(pId,policyName,policyType,company,tenure)SELECT i.policyId,i.policyName,i.policyType,i.company,i.tenure from com.nt.entity.InsurancePolicy as i where i.tenure>=:min")
public class PremiumInsurancePolicy implements Serializable {
	@Id
	private Long pId;
	private String policyName;
	private String policyType;
	private String company;
	private Integer tenure;

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	@Override
	public String toString() {
		return "PremiumInsurancePolicy [pId=" + pId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}

}
