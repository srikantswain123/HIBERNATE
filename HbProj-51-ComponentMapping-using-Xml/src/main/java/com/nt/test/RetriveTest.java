package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Student_info;
import com.nt.utility.HibernateUtility;

public class RetriveTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		ses=HibernateUtility.getSession();
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			Query query=ses.createQuery("from Student_info where saddr.cityName=:city");
			query.setParameter("city","Washington");
			List<Student_info> list=query.getResultList();
			list.forEach(System.out::println);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}

	}

}
