package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtility;

public class CollectionMappingTest {

	public static void main(String[] args) {
		//get session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		Employee emp=new Employee();
		//set employee data
		emp.setEname("raja");
		emp.setEadd("vizag");
		emp.setFriends(List.of("suresh","mahesh","rajesh","suresh"));
		emp.setMobileNo(Set.of(9999999l,8888888l,7777777l));
		emp.setBankAccount(Map.of("SBI",123456l,"UNION",456789l,"ICICI",987654l));
		try {
			//check and gate transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//save object
			ses.save(emp);
			flag=true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}//catch
		finally {
			//perform transaction
			if(flag) {
				tx.commit();
				System.out.println("Object saved");
			}else {
				tx.rollback();
				System.out.println("Object Not saved");
			}
			HibernateUtility.closeSessionFactory();
		}//finally

	}//main

}//class
