package com.nt.dao;

import java.util.List;

import com.nt.entity.InsurancePolicy;

public interface IInsurancePolicyDao {
	public List<InsurancePolicy> getResult(int pageResult,int maxResult);
	public Integer getResultCount();
	

}
