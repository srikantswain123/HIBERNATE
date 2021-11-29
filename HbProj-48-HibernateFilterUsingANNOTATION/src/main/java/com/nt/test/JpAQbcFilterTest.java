package com.nt.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtility;

public class JpAQbcFilterTest {

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
		CriteriaBuilder builder=ses.getCriteriaBuilder();
		CriteriaQuery<BankAccount> cTquery=builder.createQuery(BankAccount.class);
		Root<BankAccount> root=cTquery.from(BankAccount.class);
		cTquery.select(root);
		//create Hql Query add Jpa Criteria Object
		Query query=ses.createQuery(cTquery);
		List<BankAccount> list=query.getResultList();
		list.forEach(System.out::println);

	}//main

}//class
