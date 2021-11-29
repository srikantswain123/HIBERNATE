package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CanteenCard;
import com.nt.entity.Employee;
import com.nt.utitlity.HibernateUtility;

public class One_To_One_Dao_Impl implements IOne_To_One_pk_Dao {

	@Override
	public void saveObject() {
		//get session Object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//make person object
		Employee emp=new Employee("rajat", "delhi", 45687.0f);
		CanteenCard card=new CanteenCard("lawrence", "Noida", "gold");
		emp.setCanteenDetails(card);
		card.setEmp(emp);
		
		try {
			//begin transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			ses.save(emp);
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
