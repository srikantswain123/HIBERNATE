package com.nt.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.nt.entity.Employee;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		ServiceRegistry registry=null;
		Configuration cfg=null;
		//create configuration
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//configurre all annotated class
		cfg.addAnnotatedClass(Employee.class);
		
		registry=builder.applySettings(cfg.getProperties()).build();
		factory=cfg.buildSessionFactory(registry);
	}
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
		 ses=factory.getCurrentSession();
		
			return ses;
	}
	public static void closeSessionFactory() {
		if(factory!=null)
		factory.close();
	}

}
