package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileCustomer;
import com.nt.util.HibernateUtil;

public class VersionIngTest {

	public static void main(String[] args) {
		//get session
		Session ses=null;
		MobileCustomer mc=null;
		Transaction tx=null;
		boolean flag=false;
		//get session Object
		ses=HibernateUtil.getSession();
		mc=new MobileCustomer();
		mc.setMobileNo(999999l);
		mc.setCallerTune("dil jale");
		try {
			tx=ses.beginTransaction();
			ses.save(mc);
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
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		}//finaly
		
		

	}

}
