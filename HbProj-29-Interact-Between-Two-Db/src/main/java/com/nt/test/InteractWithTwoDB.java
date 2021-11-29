package com.nt.test;

import com.nt.dao.IProductDAO;
import com.nt.dao.ProductDaoImpl;
import com.nt.utility.MySQl_HibernateUtility;
import com.nt.utility.Oracle_HibernateUtility;

public class InteractWithTwoDB {

	public static void main(String[] args) {
		IProductDAO dao=new ProductDaoImpl();
		System.out.println(dao.getData(2));
		
		Oracle_HibernateUtility.closeFactory();
		MySQl_HibernateUtility.closeFactory();
		

	}

}
