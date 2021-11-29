package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.service.ServiceRegistry;

import com.nt.customConnection.CustomConnection;

public class HibernateUtility {
	private static SessionFactory factory;
	static {
		StandardServiceRegistryBuilder builder=null;
	     ServiceRegistry registry=null;
		

		Configuration cfg = null;
		try {
			cfg=new Configuration();
			cfg.configure("com/nt/cfgs/Hibernate.cfg.xml");
			cfg.addResource("com/nt/entity/Insurance.hbm.xml");
			builder=new StandardServiceRegistryBuilder();
			//add service
			builder.addService(ConnectionProvider.class, new CustomConnection());
			registry=builder.applySettings(cfg.getProperties()).build();
             factory = cfg.buildSessionFactory(registry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Session getSession() {
		Session ses = null;
		if (factory != null)
			ses = factory.openSession();
		return ses;
	}

	public static void closeSession(Session ses) {
		if (ses != null)
			ses.close();
	}

	public static void closeFactory() {
		if (factory != null)
			factory.close();
	}

}
