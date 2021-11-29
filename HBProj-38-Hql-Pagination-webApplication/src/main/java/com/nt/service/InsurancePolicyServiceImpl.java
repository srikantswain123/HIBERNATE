package com.nt.service;

import java.util.List;

import com.nt.dao.IInsurancePolicyDao;
import com.nt.dao.InsurancePolicyDaoImpl;
import com.nt.dto.InsurancePolicyDto;
import com.nt.entity.InsurancePolicy;

public class InsurancePolicyServiceImpl implements IInsurancePolicyService {
	IInsurancePolicyDao dao;
	

	public InsurancePolicyServiceImpl() {
		dao=new InsurancePolicyDaoImpl();
	}


	@Override
	public List<InsurancePolicyDto> getResult(int firsResult) {
		List<InsurancePolicyDto> listDto=null;
		List<InsurancePolicy> listEntity=null;
		//get  entity result for dao
		Integer page=dao.getResultCount();
		if(page/firsResult!=0)
		    
		
		listEntity=dao.getResult(firsResult, maxResult);
		
		return null;
	}

}
