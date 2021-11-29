package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		
		Configuration cfg=null;
		try {
		//bootstarp Hibernate
		cfg=new Configuration();
		cfg.addFile("src\\main\\java\\com\\nt\\entity\\Insurance.hbm.xml");
		
		
		factory=cfg.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) 
			 ses=factory.openSession();
			return ses;
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeFactory() {
		if(factory!=null)
			factory.close();
	}

}
