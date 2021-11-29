package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.util.HibernateUtil;

public class UpdateTest {
	public static void main(String[] args) {
		BankAccount account=null;
		Session ses=null;
		boolean flag=false;
		
		account=new BankAccount();
		account.setAcno(101);
		account.setAchname("mandeep");
		account.setBalance(400000.0f);

		ses=HibernateUtil.getSession();
		
		Transaction tx=null;
		
		
		try {
			tx=ses.beginTransaction();
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
