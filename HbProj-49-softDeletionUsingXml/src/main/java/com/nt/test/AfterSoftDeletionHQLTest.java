package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtility;

public class AfterSoftDeletionHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		//get sesssion oBject
		ses=HibernateUtility.getSession();
		
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			Query query=ses.createQuery("FROM com.nt.entity.BankAccount");
			List<BankAccount> list=query.getResultList();
			list.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeSessionFactory();
		}//finally

	}//main

}//class
