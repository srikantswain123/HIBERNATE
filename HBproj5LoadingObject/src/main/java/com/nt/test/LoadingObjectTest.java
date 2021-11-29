package com.nt.test;

import org.hibernate.Session;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class LoadingObjectTest {
	public static void main(String[] args) {
		InsurancePolicy policy=null;
		Session ses=null;
		try {
			ses=HibernateUtility.getSession();
			policy=ses.load(InsurancePolicy.class,101L);
			System.out.println(policy.getClass().hashCode());
			policy=ses.get(InsurancePolicy.class,101L);
			System.out.println(policy.hashCode());
					
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtility.closeSession(ses);
			HibernateUtility.closeFactory();
		}
		
		
	}

}
