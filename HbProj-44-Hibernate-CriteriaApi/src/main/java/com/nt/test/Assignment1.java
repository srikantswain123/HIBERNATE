package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtility;

public class Assignment1 {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		Criteria criteria=null;
		
		//get session oBject
		ses=HibernateUtility.getSession();
		//create dummy transaction
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		try {
			criteria=ses.createCriteria(Project.class);
			Projection proj=Projections.property("pid");
			Projection proj1=Projections.property("compName");
			Projection proj2=Projections.property("pname");
			ProjectionList plist=Projections.projectionList();
			plist.add(proj);plist.add(proj1);plist.add(proj2);
			criteria.setProjection(plist);
			
			Criterion cond1=Restrictions.between("teammemeber", 10l, 30l);
			Criterion cond2=Restrictions.ilike("compName", "o%");
			criteria.add(cond1);
			criteria.add(cond2);
			
			List<Object[]> list=criteria.list();
			list.forEach(p->{
				System.out.println(p[0]+" --"+p[1]+" --"+p[2]);
			});
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			HibernateUtility.closeFactory();
		}
		
		
	}//main

}//class
