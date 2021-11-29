package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtility;

public class HqlFilterTest {

	public static void main(String[] args) {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		//create Filter Object
		Filter filter=ses.enableFilter("BANK_ACCOUNT_STATUS");
		filter.setParameter("param1", "closed");
		filter.setParameter("param2", "blocked");
		//create Hql Query
		Query query=ses.createQuery("FROM com.nt.entity.BankAccount");
		List<BankAccount> list=query.getResultList();
		list.forEach(System.out::println);

	}//main

}//class
