package com.nt.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory factory;
	static {

		Configuration cfg = null;
		try {

			// bootstarp Hibernate
			cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
			cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:orcl");
			cfg.setProperty("hibernate.connection.username", "system");
			cfg.setProperty("hibernate.connection.password", "Srikant1234");
			cfg.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.Oracle10gDialect");
			cfg.setProperty("hibernate.connection.show_sql", "true");
			cfg.setProperty("hibernate.connection.format_sql", "true");
			cfg.addFile("src\\main\\java\\com\\nt\\entity\\Insurance.hbm.xml");

			factory = cfg.buildSessionFactory();
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
