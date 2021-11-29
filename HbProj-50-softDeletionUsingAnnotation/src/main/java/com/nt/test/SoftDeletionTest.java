package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtility;

public class SoftDeletionTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		//get sesssion oBject
		ses=HibernateUtility.getSession();
		boolean flag=false;
		
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			BankAccount acc=new BankAccount();
			acc.setAcno(101l);
			ses.delete(acc);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
			}else {
				tx.rollback();
			}
		}//finally

	}//main

}//class
