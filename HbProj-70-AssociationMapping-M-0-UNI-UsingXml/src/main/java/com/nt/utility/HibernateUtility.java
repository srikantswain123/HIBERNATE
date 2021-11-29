package com.nt.utility;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtility {
	private static SessionFactory factory;
	static {
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		ServiceRegistry registry=null;
		Configuration cfg=null;
		//create configuration
		cfg=new Configuration();
		cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//add resource
		cfg.addResource("com/nt/entity/department.hbm.xml");
		cfg.addResource("com/nt/entity/employee.hbm.xml");
		
		
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
