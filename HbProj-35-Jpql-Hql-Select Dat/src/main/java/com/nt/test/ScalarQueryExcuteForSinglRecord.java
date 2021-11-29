package com.nt.test;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class ScalarQueryExcuteForSinglRecord {
	public static void main(String[] args) {
		Session ses = null;
		Transaction tx = null;
		
		Query query=null;
		ses = HibernateUtility.getSession();
		//dummy transaction
		tx = ses.beginTransaction();
		//scalar query for executing single record
		/*List<InsurancePolicy> list=null;
		 query=ses.createQuery("FROM com.nt.entity.InsurancePolicy where policyId=:id");
		query.setParameter("id", 102l);
		list=query.getResultList();
		System.out.println(list.size());
		if(!list.isEmpty()) {
			InsurancePolicy po=list.get(0);
			System.out.println(po);
		}else {
			System.out.println("Record not found");
		}*/
		
		
		//using Agregate function
		/*List<?> list=null;
		query=ses.createQuery("select count(*) from com.nt.entity.InsurancePolicy");
		list=query.getResultList();
		System.out.println(list.size());
		if(!list.isEmpty()) {
			long count=(long)list.get(0);
			System.out.println(count+" Record Founds");
		}*/
		//using UniqueResult() for single record no need of taking collection
		
		/*query=ses.createQuery("from com.nt.entity.InsurancePolicy where policyId=:id");
		query.setParameter("id", 101l);
		InsurancePolicy policy=(InsurancePolicy) query.uniqueResult();
		if(policy!=null) {
		System.out.println(policy);
		}else {
			System.out.println("not record found");
		}
		*/
		
		//using optionl Api execcute single Record
		Optional<InsurancePolicy> opt=null;
		query=ses.createQuery("from com.nt.entity.InsurancePolicy where policyId=:id");
		query.setParameter("id", 101l);
	    opt=query.uniqueResultOptional();
	    if(opt.isPresent()) {
	    	System.out.println(opt.get());
	    }else {
	    	System.out.println("record no found");
	    }
		
		
	}//main

}//class
