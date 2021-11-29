package com.nt.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class LoadingObjectTest {
	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		Query<InsurancePolicy> query = null;
		List<InsurancePolicy> list = null;
		/*try {
			ses=HibernateUtility.getSession();
			tx=ses.beginTransaction();
			query=ses.createQuery("FROM com.nt.entity.InsurancePolicy");
			list=query.getResultList();
			
			 * list.forEach(policy->{ System.out.println(policy); });
			 
			list.forEach(System.out::println);
			
			
					
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtility.closeSession(ses);
			HibernateUtility.closeFactory();
		}
		*/
		//QUERY.ITERATE
		/*ses=HibernateUtility.getSession();
		tx=ses.beginTransaction();
		query=ses.createQuery("FROM com.nt.entity.InsurancePolicy");
		Iterator<InsurancePolicy> itr=query.iterate();
		itr.forEachRemaining(System.out::println);*/
	
		//select query with condition
		/*ses=HibernateUtility.getSession();
		tx=ses.beginTransaction();
		query=ses.createQuery("FROM com.nt.entity.InsurancePolicy WHERE policyId>=?1 AND policyId<=?2");
		query.setParameter(1, 101l);
		query.setParameter(2,103l);
		list=query.getResultList();
		list.forEach(System.out::println);*/
		
		
		//hql Select query with named parameter
		/*ses=HibernateUtility.getSession();
		tx=ses.beginTransaction();
		query=ses.createQuery("FROM com.nt.entity.InsurancePolicy WHERE policyId>=:id AND policyId<=:id");
		query.setParameter("id", 101l);
		query.setParameter("id", 104l);
		list=query.getResultList();
		list.forEach(System.out::println);*/
		
		//hql qery using like operator
		ses=HibernateUtility.getSession();
		tx=ses.beginTransaction();
		query=ses.createQuery("FROM com.nt.entity.InsurancePolicy WHERE tenure like :name");
		query.setParameter("name", "l%");
		list=query.getResultList();
		list.forEach(System.out::println);
		
		
			
			
			

	}

}
