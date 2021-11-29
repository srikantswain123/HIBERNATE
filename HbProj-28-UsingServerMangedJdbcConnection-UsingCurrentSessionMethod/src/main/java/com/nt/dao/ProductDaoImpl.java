package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.HibernateUtility;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product getData(int pid) {
		Session ses=null,ses1=null;
		Transaction tx=null;
		Product prod=null;
		ses=HibernateUtility.getSession();
		ses1=HibernateUtility.getSession();
		tx=ses.beginTransaction();
		System.out.println(ses.hashCode()+"  "+ses1.hashCode());
		prod=ses.get(Product.class, pid);
		return prod;
	}

}
