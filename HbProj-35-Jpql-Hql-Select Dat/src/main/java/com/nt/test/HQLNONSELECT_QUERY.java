package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtility;

public class HQLNONSELECT_QUERY {
	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		
		Query query=null;
		ses = HibernateUtility.getSession();
		boolean flag=false;
		int count=0;
		try {
			tx = ses.beginTransaction();	
			query=ses.createQuery("UPDATE com.nt.entity.InsurancePolicy SET tenure=tenure + :ten WHERE policyName like:ichar");
			query.setParameter("ten", 20);
			query.setParameter("ichar","j%");
			count=query.executeUpdate();
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" record Updated");
			}else {
				System.out.println("record not found for update");
			}
			HibernateUtility.closeFactory();
		}
		
		
		
		
	}//main

}//class
