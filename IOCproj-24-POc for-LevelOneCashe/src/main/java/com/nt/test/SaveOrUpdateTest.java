package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Membership;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		Session ses=null;
		Membership member=null,member1=null;
	     //get Session
		ses=HibernateUtil.getSession();
		
		//prepare object
		try {
			member=ses.get(Membership.class, 66666l);
			System.out.println("1::"+member);
			member1=ses.get(Membership.class, 66666l);
			System.out.println("2::"+member1);
			ses.evict(member1);
			member=ses.get(Membership.class, 66666l);
			System.out.println("3::"+member);
			member1=ses.get(Membership.class, 66666l);
			System.out.println("4::"+member1);
			ses.clear();
			member1=ses.get(Membership.class, 66666l);
			System.out.println("5::"+member1);
			
			
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			//perform tx mgmt
			 //close objs
			 HibernateUtil.closeSession(ses);
			 HibernateUtil.closeSessionFactory();
		}
		

	}

}
