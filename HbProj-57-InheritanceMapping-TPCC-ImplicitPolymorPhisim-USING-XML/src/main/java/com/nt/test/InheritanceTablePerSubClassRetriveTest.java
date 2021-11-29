package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Person;
import com.nt.utility.HibernateUtility;

public class InheritanceTablePerSubClassRetriveTest{

	public static void main(String[] args) {
		//get Session Object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			Query<Person> query=ses.createQuery("from Person");
			List<Person> list=query.getResultList();
			list.forEach(System.out::println);
			//get Result from student
			System.out.println("-----------------------------------------");
			Query<Person> query1=ses.createQuery("from Student");
			List<Person> list1=query1.getResultList();
			list1.forEach(System.out::println);
			//get Result from Customer
			System.out.println("-----------------------------------------");
			Query<Person> query2=ses.createQuery("from Student");
			List<Person> list2=query2.getResultList();
			list2.forEach(System.out::println);
			
		}catch(HibernateException he) {
			he.printStackTrace();
		}//catch
		finally {
			HibernateUtility.closeSessionFactory();
		}//finally

	}//main

}//class
