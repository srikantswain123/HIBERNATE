package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	private static SessionFactory factory;
	static {
		
		Configuration cfg=null;
		try {
		//bootstarp Hibernate
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/Hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Session getSession() {
		Session ses=null;
		ses=threadLocal.get();
		if(ses==null) {
			if(factory!=null) {
				ses=factory.openSession();
				threadLocal.set(ses);
			}
		}
		return ses;
		
	}
	public static void closeSession() {
		Session ses=null;
		ses=threadLocal.get();
		if(ses!=null) {
			ses.close();
			threadLocal.remove();
		}
	}
	public static void closeFactory() {
		if(factory!=null)
			factory.close();
	}

}
