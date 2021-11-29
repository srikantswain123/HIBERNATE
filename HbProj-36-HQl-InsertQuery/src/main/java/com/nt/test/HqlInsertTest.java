package com.nt.test;

import com.nt.dao.IinsurancePolicyDAO;
import com.nt.dao.InsurancePolicyDaoImpl;
import com.nt.utility.HibernateUtility;

public class HqlInsertTest {

	public static void main(String[] args) {
		IinsurancePolicyDAO dao=null;
		dao=new InsurancePolicyDaoImpl();
		System.out.println(dao.transferData(25));
		//close Session factory
		HibernateUtility.closeFactory();

	}

}
