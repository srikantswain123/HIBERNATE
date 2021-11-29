package com.nt.test;

import com.nt.dao.IinsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDAOImpl;

public class EntityFunctionTest {

	public static void main(String[] args) {
		IinsurancePolicyDAO dao=null;
		dao=new InsurancePolicyDAOImpl();
		String result[]=dao.getRsultById(110);
		System.out.println(result[0]+" "+result[1]+" "+result[2]);
		

	}

}
