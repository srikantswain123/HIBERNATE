package com.nt.test;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.utility.HibernateUtility;

public class InheritanceTest_TPCH {

	public static void main(String[] args) {
		//get Session
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//creaete Crad Payment Object
		CardPayment cap=new CardPayment();
		cap.setCardNumber(94894984L);
		cap.setCardType("Credit");
		cap.setAmount(94646f);
		cap.setPaymentGateway("VISA");
		//create CheckPayment Object
		ChequePayment cqp=new ChequePayment();
		cqp.setChequeNo(48948484L);
		cqp.setChequeType("SELF");
		cqp.setAmount(50000f);
		cqp.setExpiryDate(LocalDate.of(2021, 11, 11));
		try {
			//check and begin transaction Object
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//save Card ANd Cheque Object As Persitance Operation
			ses.save(cap);
			ses.save(cqp);
		    flag=true;
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}//catch
		finally {
			//perform transaction mgmt
			if(flag) {
				tx.commit();
				System.out.println("Object Saved");
			}//if
			else {
				tx.rollback();
				System.out.println("Object Not Saved");
			}//else
				
			//close session factory
			HibernateUtility.closeSessionFactory();
			
		}//finally

	}//main

}//class
