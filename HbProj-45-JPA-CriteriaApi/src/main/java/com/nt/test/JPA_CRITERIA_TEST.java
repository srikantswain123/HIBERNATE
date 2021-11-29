package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class JPA_CRITERIA_TEST {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//this query build upon select * from project
			//create jpa  CriteriaBuilder query
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for defining top level query
			CriteriaQuery<Project> ctquery=builder.createQuery(Project.class);
			//defines from clause for performing sql operation select * from where from is the root clause
			Root<Project> root=ctquery.from(Project.class);
			//doing select operation
			ctquery.select(root);
			
			//prepare hql query for excute query operation
			Query query=ses.createQuery(ctquery);
			//execute jpa logic
			List<Project> list=query.getResultList();
			//execute Query
			list.forEach(System.out::println);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}

	}//main

}//class
