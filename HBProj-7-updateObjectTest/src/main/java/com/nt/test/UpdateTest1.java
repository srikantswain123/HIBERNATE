package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.util.HibernateUtil;

public class UpdateTest1 {
	public static void main(String[] args) {
		BankAccount account=null;
		Session ses=null;
		boolean flag=false;
		
		account=new BankAccount();
		

		ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		
		account=ses.get(BankAccount.class,101);
		try {
			tx=ses.beginTransaction();
			account.setAcno(101);
			account.setBalance(500);
			ses.update(account);
			flag=true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag==true) {
				tx.commit();
			}else if(flag==false) {
				tx.rollback();
			}
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
