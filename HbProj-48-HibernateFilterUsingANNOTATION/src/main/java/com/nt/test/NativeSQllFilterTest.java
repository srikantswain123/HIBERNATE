package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtility;

public class NativeSQllFilterTest {

	public static void main(String[] args) {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		// Filter Object not supported in NativeSql
		Filter filter=ses.enableFilter("BANK_ACCOUNT_STATUS");
		filter.setParameter("param1", "closed");
		filter.setParameter("param2", "blocked");
		//create Nativesql Query
		NativeQuery<BankAccount> query=ses.createSQLQuery("SELECT * FROM BANK_ACCOUNT");
		query.addEntity(BankAccount.class);
		List<BankAccount> list=query.getResultList();
		list.forEach(System.out::println);

	}//main

}//class
