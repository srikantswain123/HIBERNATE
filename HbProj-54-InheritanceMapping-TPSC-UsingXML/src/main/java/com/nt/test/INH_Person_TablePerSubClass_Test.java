package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Person;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtility;

public class INH_Person_TablePerSubClass_Test {

	public static void main(String[] args) {
		//get Session Object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//person Object
		Person per=new Person();
		//student Object
		Student st=new Student();
		//customer Object
		Customer co=new Customer();
		try {
			//check and get transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//store person data
			per.setName("morgan");
			per.setAddrs("abudabi");
			//set Student Data
			st.setName("alexa");
			st.setAddrs("jordan");
			st.setCollege("philipines");
			st.setBranch("cs");
			st.setAvg(78.2f);
			//set CTustomer Data
			co.setName("Abdul Khatra");
			co.setAddrs("Saudi");
			co.setDeptno(1245);
			co.setDesg("Project manager");
			co.setSal(789545.02f);
			
			//save data to db
			ses.save(per);
			ses.save(st);
			ses.save(co);
			flag=true;
			
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("Object Saved");
			}else {
				tx.rollback();
				System.out.println("Object Not saved");
			}
				
			HibernateUtility.closeSessionFactory();
		}//finally
	}//main

}//class
