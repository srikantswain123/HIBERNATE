package com.nt.dao;

import java.util.List;

import com.nt.entity.InsurancePolicy;

public interface IinsurancePolicyDAO {
	
	public List<InsurancePolicy> getResultsByTenure(int start,int end);

}
