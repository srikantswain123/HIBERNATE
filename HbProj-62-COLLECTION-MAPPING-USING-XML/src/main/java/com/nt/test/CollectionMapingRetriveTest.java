package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtility;

public class CollectionMapingRetriveTest {

	public static void main(String[] args) {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive()) 
				tx=ses.beginTransaction();
			Query<Employee> query=ses.createQuery("FROM com.nt.entity.Employee");
			List<Employee> list=query.getResultList();
			list.forEach(System.out::println);
		}catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
		HibernateUtility.closeSessionFactory();
		}

	}//main

}//class
