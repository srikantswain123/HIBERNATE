package com.nt.test;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class JPA_CRITERIA_nonSelect_TEST {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		long count=0l;
		boolean flag=false;
		//update record
		/*try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create jpa  CriteriaBuilder query
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//update criteria query for defining top level query
			CriteriaUpdate<Project> cUpdate=builder.createCriteriaUpdate(Project.class);
			//craeate root object
			Root<Project> root=cUpdate.from(Project.class);
			//set value
			cUpdate.set(root.get("teammemeber"), 55).set(root.get("location"),"colombo").where(builder.equal(root.get("compName"), "Oracle"));
			//create hql query
			Query<Long> query=ses.createQuery(cUpdate);
			 count=query.executeUpdate();
			 flag=true;
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" are updated");
			}else {
				tx.rollback();
				System.out.println("no records are modified");
			}
				
			HibernateUtility.closeFactory();
		}*/
		//delete record
		try {
			ses=HibernateUtility.getSession();
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create jpa  CriteriaBuilder query
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//delete criteria query for defining top level query
			CriteriaDelete<Project> cDelete=builder.createCriteriaDelete(Project.class);
			//create root object for delete row
			Root<Project> root=cDelete.from(Project.class);
			//delete from project where team size between(?,?)
			cDelete.where(builder.between(root.get("pid"), 10, 13));
			//create hql Query object
			Query<Long> query=ses.createQuery(cDelete);
			count=query.executeUpdate();
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
				System.out.println(count+" are deleted");
			}else {
				tx.rollback();
				System.out.println("no records are deleted");
			}
				
			HibernateUtility.closeFactory();
		}
		
	}//main

}//class
