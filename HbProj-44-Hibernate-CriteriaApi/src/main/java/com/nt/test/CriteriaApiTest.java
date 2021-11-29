package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class CriteriaApiTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Criteria criteria=null;
		
		//get session oBject
		ses=HibernateUtility.getSession();
		//criteria with entity value with out any conditon
		try {
		  List<Project> list=null;
			//start transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create criteria object with entity class
			criteria=ses.createCriteria(Project.class);
			criteria.setFirstResult(1);
			criteria.setMaxResults(3);
			//get result 
			list=criteria.list();
			//print records
			list.forEach(System.out::println);
			
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
		
		
		//criteria with entity value with  conditon
		/*try {
		 * List<Project> list=null;
			//start transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create criteria object with entity class
			criteria=ses.createCriteria(Project.class);
			//add condition
			Criterion cond1=Restrictions.ge("teammemeber",12l);
			Criterion cond2=Restrictions.le("teammemeber", 30l);
			//add criterion object to criteria object
			criteria.add(cond1);
			criteria.add(cond2);
			//add oredr by condition
			Order order1=Order.desc("compName");
			//add order object to criteria object
			criteria.addOrder(order1);
			//get result 
			list=criteria.list();
			//print records
			list.forEach(System.out::println);
			
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//adding multiple condition on criteriia object
		/*try {
			//start transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create criteria object with entity class
			criteria=ses.createCriteria(Project.class);
			Criterion cond1=Restrictions.between("teammemeber",10l, 30l);
			Criterion cond2=Restrictions.in("compName", "oracle","micron");
			Criterion cond3=Restrictions.ilike("pname", "j%");
			Criterion finalCond=Restrictions.or(Restrictions.and(cond1, cond2),cond3);
			criteria.add(finalCond);
			List<Project> list=criteria.list();
			list.forEach(System.out::println);
			
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//adding sql condition
		/*try {
			//start transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create criteria object with entity class
			criteria=ses.createCriteria(Project.class);
			Criterion cond1=Restrictions.sqlRestriction("rownum>=? and rownum<=?",new Object[] {1,4},new Type[] {StandardBasicTypes.INTEGER,StandardBasicTypes.INTEGER});
			criteria.add(cond1);
			List<Project> list=criteria.list();
			list.forEach(System.out::println);
			
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
	}//main

}//class
