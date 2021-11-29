package com.nt.test;

import com.nt.dao.IOneToManyDao;
import com.nt.dao.OneToManyDaoImpl;
import com.nt.utility.HibernateUtility;

public class OneToManyTest {

	public static void main(String[] args) {
		//create dao object
		IOneToManyDao dao=new OneToManyDaoImpl();
		//invoke method
		//dao.saveObjectUsingParent();
		dao.saveObjectUsingChild();
		//close session factory
		HibernateUtility.closeSessionFactory();

	}

}
