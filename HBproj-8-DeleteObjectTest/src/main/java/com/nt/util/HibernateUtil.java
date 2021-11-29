package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory factory=null;
	static {
		Configuration cfg=null;
		//bootStrap hibernate Framework
	  cfg=new Configuration();
	  //configure hibernate configuration file
	  cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
	  factory=cfg.buildSessionFactory();
		
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null) {
		 ses=factory.openSession();
		 return ses;
		}else {
			return ses;
		}
		
		
	}
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}

}
