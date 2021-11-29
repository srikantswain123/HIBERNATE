package com.nt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

public class SecondLevelCasheTesting {

	public static void main(String[] args) {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		//load Object
		InsurancePolicy policy=ses.get(InsurancePolicy.class, 101l);
		System.out.println(policy);//get from db and load in 2nd level casche and store also  1st level cache
		ses.evict(policy);//remove from l1 cashe
		System.out.println("------------------------------------------------------------------------------");
		InsurancePolicy policy1=ses.get(InsurancePolicy.class, 101l);
		System.out.println(policy1);//get friom l2 cashe and load in l1 cashe
		
             		

	}

}
