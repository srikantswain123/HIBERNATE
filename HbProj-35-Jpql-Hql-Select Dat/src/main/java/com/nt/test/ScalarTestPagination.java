package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class ScalarTestPagination {
	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		Query query = null;
		List<InsurancePolicy> list=null;
		ses = HibernateUtility.getSession();
		//dummy transaction
		tx = ses.beginTransaction();
		query=ses.createQuery("FROM com.nt.entity.InsurancePolicy");
		query.setFirstResult(2);//set strting result u want
		query.setMaxResults(2);//set how many results u want to show in a spage
		list=query.getResultList();
		list.forEach(System.out::println);
		
		
	}

}
