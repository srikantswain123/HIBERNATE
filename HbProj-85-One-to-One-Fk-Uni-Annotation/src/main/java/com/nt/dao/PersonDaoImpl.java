package com.nt.dao;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Passport;
import com.nt.entity.Person;
import com.nt.utitlity.HibernateUtility;

public class PersonDaoImpl implements IPersonDao {

	@Override
	public void saveObject() {
		//get session Object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//make person object
		Person per=new Person("raja", "hyd");
		//make Passport Object
		Passport port=new Passport("india", LocalDate.of(2022, 12, 30));
		port.setPerson(per);
		try {
			//begin transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			ses.save(port);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}else {
				tx.rollback();
				System.out.println("problem towards saving Object");
			}
		}

	}

}
