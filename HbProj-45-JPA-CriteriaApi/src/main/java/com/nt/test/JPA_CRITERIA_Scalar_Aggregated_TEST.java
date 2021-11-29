package com.nt.test;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class JPA_CRITERIA_Scalar_Aggregated_TEST {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create jpa  CriteriaBuilder query
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for defining top level query
			CriteriaQuery<Long> ctquery=builder.createQuery(Long.class);
			//defines from clause for performing sql operation select * from where from is the root clause
			Root<Project> root=ctquery.from(Project.class);
			//doing select operation
			ctquery.multiselect(builder.count(root.get("pid")));
	       //create hql query
			Query<Long> query=ses.createQuery(ctquery);
			long count=query.uniqueResult();
			System.out.println("no of records are "+count);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
		
	}//main

}//class
