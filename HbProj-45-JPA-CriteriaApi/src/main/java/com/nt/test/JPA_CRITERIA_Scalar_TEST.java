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

public class JPA_CRITERIA_Scalar_TEST {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		//query for multiple scalar query
		/*try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create jpa criteria builder
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for select operation
			CriteriaQuery<Object[]> ctQuery=builder.createQuery(Object[].class);
			//create root object for acessing multiple column
			Root<Project> root=ctQuery.from(Project.class);
			//select pid,pname form poject where location =?
			ctQuery.multiselect(root.get("pid"),root.get("pname")).where(builder.equal(root.get("location"), "delhi"));
			//add to hql query
			Query<Object[]> query=ses.createQuery(ctQuery);
			//get  value
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				System.out.println(row[0]+"----"+row[1]);
			});
			
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		
		//query for single record
		try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create jpa criteria builder
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for select operation
			CriteriaQuery<String> ctQuery=builder.createQuery(String.class);
			//create root object for acessing multiple column
			Root<Project> root=ctQuery.from(Project.class);
			//select pname where teammember>=? order by pname desc;
			ctQuery.multiselect(root.get("pname")).where(builder.ge(root.get("teammemeber"), 16l)).orderBy(builder.asc(root.get("pname")));
			//add to hql query
			Query<String> query=ses.createQuery(ctQuery);
			//get  value
			List<String> list=query.getResultList();
			list.forEach(System.out::println);
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
		
	}//main

}//class
