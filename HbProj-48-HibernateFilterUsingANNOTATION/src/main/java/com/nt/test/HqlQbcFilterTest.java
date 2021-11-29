package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtility;

public class HqlQbcFilterTest {

	public static void main(String[] args) {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		// Filter Object 
		Filter filter=ses.enableFilter("BANK_ACCOUNT_STATUS");
		filter.setParameter("param1", "closed");
		filter.setParameter("param2", "blocked");
		//create Hibernate qbc
		Criteria criteria=ses.createCriteria(BankAccount.class);
		List<BankAccount> list=criteria.list();
		list.forEach(System.out::println);

	}//main

}//class
