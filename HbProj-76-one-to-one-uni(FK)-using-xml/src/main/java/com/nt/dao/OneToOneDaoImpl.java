package com.nt.dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtility;

public class OneToOneDaoImpl implements IOneToOneDAO {

	@Override
	public void saveObject() {
		//get SessionObject
		Session ses=HibernateUtility.getSession();
		//begin transaction
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		boolean flag=false;
		try {
			//prepare Person Object
			Person per=new Person("raja", "mumbai");
			//prepare Passport Object
			Passport ps=new Passport("india", LocalDate.of(2030, 10, 23));
			ps.setDetails(per);
			//prepare person 2nd object
			Person per1=new Person("raftar","delhi");
			ses.save(ps);
			ses.save(per1);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			//perform transaction
			if(flag) {
				tx.commit();
				System.out.println("Object Saved");
			}else {
				tx.rollback();
				System.out.println("Object not saved");
			}
			//close session Factory
			HibernateUtility.closeSessionFactory();
		}//finally

	}//main

}//class
