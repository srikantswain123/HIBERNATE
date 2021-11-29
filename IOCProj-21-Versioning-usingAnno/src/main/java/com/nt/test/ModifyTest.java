package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileCustomer;
import com.nt.util.HibernateUtil;

public class ModifyTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		MobileCustomer mc=null;
		Transaction tx=null;
		boolean flag=false;
		//get session Object
		ses=HibernateUtil.getSession();
		mc=ses.get(MobileCustomer.class, 29);
		try {
			tx=ses.beginTransaction();
			mc.setCallerTune("dil katliyyya");
			flag=true;
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}
		finally {
			if(flag)
				tx.commit();
			else
				tx.rollback();
			System.out.println("Version coutn:::"+mc.getVersion_count());
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		}//finaly
		
		

	}

}
