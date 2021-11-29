package com.nt.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class JPA_CRITERIA_With_Condition_TEST {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		/*try {
			//prepare jpa query with condition
			//--------------------------------------------//
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//get criteria builder query for jpa support
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create Criteria query on entity class with top level query
			CriteriaQuery<Project> ctquery=builder.createQuery(Project.class);
			//create from clause for on from condition
			Root<Project> root=ctquery.from(Project.class);
			//add select operation on root object
			ctquery.select(root);
			//preparecondition
			ParameterExpression<Long> pex=builder.parameter(Long.class);
			ParameterExpression<Long> pex1=builder.parameter(Long.class);
			//use predicate for condition
			Predicate pr1=builder.ge(root.get("pid"), pex);
			Predicate pr2=builder.le(root.get("pid"), pex1);
			//create predicate for andn clause
			Predicate finalCond=builder.and(pr1, pr2);
			//create where clause
			ctquery.where(finalCond);
			//add order by condition
			Order order=builder.desc(root.get("pname"));
			//add predicate to  criterai query
			ctquery.orderBy(order);
			//prepare hql query 
			Query query=ses.createQuery(ctquery);
			//set parameter
			query.setParameter(pex, 10l);
			query.setParameter(pex1, 15l);
			//get List object for execute Query
			List<Project> list=query.getResultList();
			//execute query
			list.forEach(System.out::println);
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
		*/
		//excute logic using method chaining
		/*try {
			//prepare jpa query with condition
			//--------------------------------------------//
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//get criteria builder query for jpa support
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create Criteria query on entity class with top level query
			CriteriaQuery<Project> ctquery=builder.createQuery(Project.class);
			//create from clause for on from condition
			Root<Project> root=ctquery.from(Project.class);
			//add select operation on root object
			ctquery.select(root).where(builder.and(builder.ge(root.get("pid"), 10l),builder.le(root.get("pid"),15l))).orderBy(builder.desc(root.get("pname")));
			//create hql query
			Query query=ses.createQuery(ctquery);
			//execute logic
			List<Project> list=query.getResultList();
			//execute
			list.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		
		//craete query with in operator
		
		/*try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//cretae criteria builder for jpa specification on ses object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for top level query with entity class
			CriteriaQuery<Project> ctquery=builder.createQuery(Project.class);
			//craete Root class Object for accesing property
			Root<Project> root=ctquery.from(Project.class);
			//create query select * from Project where location in(delhi,vizag,mumbai);
			ctquery.select(root).where(root.get("location").in("delhi","vizag","mumbai"));
			//add to hql query
			Query query=ses.createQuery(ctquery);
			List<Project> list=query.getResultList();
			list.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//create with between clause
		/*try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//cretae criteria builder for jpa specification on ses object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for top level query with entity class
			CriteriaQuery<Project> ctquery=builder.createQuery(Project.class);
			//craete Root class Object for accesing property
			Root<Project> root=ctquery.from(Project.class);
			//create query select * from Project where location in(delhi,vizag,mumbai);
			ctquery.select(root).where(builder.between(root.get("teammemeber"), 10l, 20l));
			//add to hql query
			Query query=ses.createQuery(ctquery);
			List<Project> list=query.getResultList();
			list.forEach(System.out::println);
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//create query project name having 4 charecter
		try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//cretae criteria builder for jpa specification on ses object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create criteria query for top level query with entity class
			CriteriaQuery<Project> ctquery=builder.createQuery(Project.class);
			//craete Root class Object for accesing property
			Root<Project> root=ctquery.from(Project.class);
			//create query select * from Project where location in(delhi,vizag,mumbai);
			ctquery.select(root).where(builder.like(root.get("pname"),"____"));
			//add to hql query
			Query query=ses.createQuery(ctquery);
			List<Project> list=query.getResultList();
			list.forEach(System.out::println);
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
	}//main

}//class
