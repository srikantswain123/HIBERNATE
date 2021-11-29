package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class NativeSQLSelectTest {
	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;

		//get result with list WIth OBject array
		/*try {
			NativeQuery<Object[]> query=null;
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			query=ses.createSQLQuery("select * from INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?");
			query.setParameter(1, 20);
			query.setParameter(2, 60);
			List<Object[]> list=query.getResultList();
			list.forEach(entity->{
				for(Object o:entity)
					System.out.print(o+" ");
				System.out.println();
			});

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//mapped with entity class in native sql query
		/*try {
			NativeQuery<InsurancePolicy> query=null;
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			query=ses.createSQLQuery("select * from INSURANCEPOLICY WHERE TENURE>=? AND TENURE<=?");
			query.addEntity(InsurancePolicy.class);//we should must match with entity when we get entity object with nativesql
			query.setParameter(1, 20);
			query.setParameter(2, 60);
			List<InsurancePolicy> list=query.getResultList();
			list.forEach(System.out::println);
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//working with mapping query in xml file
		try {
			NativeQuery<InsurancePolicy> query=null;
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
		 query=ses.getNamedNativeQuery("get_result");
		 query.addEntity(InsurancePolicy.class);
			
			List<InsurancePolicy> list=query.getResultList();
			list.forEach(System.out::println);
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
		

	}//main

}//class
