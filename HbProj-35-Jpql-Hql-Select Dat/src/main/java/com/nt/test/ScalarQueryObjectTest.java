package com.nt.test;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtility;

public class ScalarQueryObjectTest {
	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		Query query = null;
		
		ses = HibernateUtility.getSession();
		//dummy transaction
		tx = ses.beginTransaction();
		//scalar query for multiple column value
		/*List<Object[]> list = null;
		query=ses.createQuery("SELECT policyId,policyName,company,tenure FROM InsurancePolicy where policyId>=:id1 AND policyId<=:id2");
		query.setParameter("id1", 101l);
		query.setParameter("id2", 104l);
		list=query.getResultList();
		list.forEach(result->{
			for(Object rs:result) 
				System.out.print(rs+" ");
			System.out.println();
		});
		for(Object[] l:list) {
			for(Object l1:l)
			System.out.print(l1+" ");
			System.out.println();
		}*/

		//scalar query for single column value
		/*List<String> list = null;
		query=ses.createQuery("SELECT policyName FROM InsurancePolicy where id=:id1 ");
		query.setParameter("id1", 101l);
		list=query.getResultList();
		list.forEach(System.out::println);*/
	
		
		//using iterate
		Iterator<Object[]> it = null;
		query=ses.createQuery("SELECT policyId,policyName,company,tenure FROM InsurancePolicy where policyId>=:id1 AND policyId<=:id2");
		query.setParameter("id1", 101l);
		query.setParameter("id2", 104l);
		it=query.iterate();
		it.forEachRemaining(res->{
	        for(Object rs:res) {
	        	System.out.print(rs+" ");
	        }
	        System.out.println();
		});
	}

}
