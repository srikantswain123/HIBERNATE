package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtility;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getData(int pid) {
		Session ses=null,ses1=null;
		Product prod=null;
		ses=HibernateUtility.getSession();
		ses1=HibernateUtility.getSession();
		System.out.println(ses.hashCode()+"  "+ses1.hashCode());
		prod=ses.get(Product.class, pid);
		return prod;
	}

}
