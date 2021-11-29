package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Oracle_HibernateUtility {
	private static SessionFactory factory;
	static {
		
		Configuration cfg=null;
		try {
		//bootstarp Hibernate
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/Oracle-Hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Session getSession() {
		Session ses=null;
		if(ses==null) {
			if(factory!=null) {
				ses=factory.getCurrentSession();
			}
		}
		return ses;
		
	}
	public static void closeFactory() {
		if(factory!=null)
			factory.close();
	}

}
