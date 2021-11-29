package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class NativeSQlNonSelectTest {

	public static void main(String[] args) {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		int count=0;
		boolean flag=false;
		/*try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			NativeQuery query=ses.getNamedNativeQuery("insert_record");
			query.setParameter(1, 3);
			query.setParameter(2, "abudabi");
			query.setParameter(3, "lic");
			query.setParameter(4,"Insurance");
			query.setParameter(5, 35);
			query.addEntity(InsurancePolicy.class);
			count=query.executeUpdate();
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("row updated::"+count);
			}else
				tx.rollback();
			HibernateUtility.closeFactory();
		}*/
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			NativeQuery query=ses.getNamedNativeQuery("delete_record");
			query.setParameter("id", 1);
			count=query.executeUpdate();
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("row deleted::"+count);
			}else
				tx.rollback();
			HibernateUtility.closeFactory();
		}
		
		

	}

}
