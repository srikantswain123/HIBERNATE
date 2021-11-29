package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Payment;
import com.nt.utility.HibernateUtility;

public class InhertanceSelectTest {

	public static void main(String[] args) {
		
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			//check and begin transaction Object
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			System.out.println("-------------------SuperClass-------------------");
			Query<Payment> query=ses.createQuery("FROM com.nt.entity.Payment");
			List<Payment> list=query.getResultList();
			list.forEach(System.out::println);
			System.out.println("------------------sub Class1--------------------");
			Query<Payment> query1=ses.createQuery("FROM com.nt.entity.CardPayment");
			List<Payment> list1=query1.getResultList();
			list1.forEach(System.out::println);
			System.out.println("------------------sub Class2--------------------");
			Query<Payment> query2=ses.createQuery("FROM com.nt.entity.ChequePayment");
			List<Payment> list2=query2.getResultList();
			list2.forEach(System.out::println);
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
			//close session factory
			HibernateUtility.closeSessionFactory();			
		}//finally
	}

}
