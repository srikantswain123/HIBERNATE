package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class ProjectionTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Criteria criteria=null;
		
		//get session oBject
		ses=HibernateUtility.getSession();
		//create dummy transaction
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		//create projection on single record
		/*try {
			criteria=ses.createCriteria(Project.class);
			
			Projection proj=Projections.property("compName");
			Criterion cond=Restrictions.eq("teammemeber",23l);
			criteria.add(cond);
			criteria.setProjection(proj);
			List<String> list=criteria.list();
			list.forEach(System.out::println);
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//create projection on multiple column value
		/*try {
			criteria=ses.createCriteria(Project.class);
			
			Projection proj=Projections.property("compName");
			Projection proj1=Projections.property("teammemeber");
			ProjectionList plist=Projections.projectionList();
			plist.add(proj1);plist.add(proj);
			
			criteria.setProjection(plist);
			List<Object[]> list=criteria.list();
			list.forEach(p->{
				System.out.println(p[0]+" --"+p[1]);
			});
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}*/
		//using projection for agregate function
		try {
			criteria=ses.createCriteria(Project.class);
			
			Projection proj=Projections.rowCount();
			Projection proj1=Projections.max("teammemeber");
			ProjectionList plist=Projections.projectionList();
			plist.add(proj);plist.add(proj1);
			criteria.setProjection(plist);
			
			List<Object[]> list=criteria.list();
			list.forEach(p->{
				System.out.println(p[0]+" --"+p[1]);
				
				
			});
			
			
		
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
	}//main

}//class
