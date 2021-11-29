package com.nt.test;

import java.util.List;

import com.nt.dao.IinsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOImpl;
import com.nt.entity.InsurancePolicy;

public class ProcedureWithEnitityTEST {

	public static void main(String[] args) {
		IinsurancePolicyDAO dao=null;
		//get Insurance Policy object
		dao=new InsurancePolicyDAOImpl();
		List<InsurancePolicy> list=dao.getResultsByTenure(20, 70);
		list.forEach(System.out::println);

	}

}
