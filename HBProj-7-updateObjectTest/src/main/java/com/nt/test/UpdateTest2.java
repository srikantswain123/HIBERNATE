package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.util.HibernateUtil;

public class UpdateTest2 {
	public static void main(String[] args) {
		BankAccount account=null;
		Session ses=null;
		boolean flag=false;
		
		
		

		ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		
		
		try {
			tx=ses.beginTransaction();
			account=ses.get(BankAccount.class,103);
			if(account!=null) {
			account.setBalance(54825);
			
			flag=true;
			System.out.println("object Updated");
			}else {
				flag=false;
				System.out.println("object not updated");
			}
			
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag==true) {
				tx.commit();
				System.out.println("object found Updated");
			}else if(flag==false) {
				tx.rollback();
				System.out.println("object not found and Updated");
			}
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
