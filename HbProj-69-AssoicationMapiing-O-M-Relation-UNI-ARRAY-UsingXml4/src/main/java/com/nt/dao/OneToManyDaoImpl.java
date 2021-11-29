package com.nt.dao;

import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PhoneNumber;
import com.nt.entity.UserInfo;
import com.nt.utility.HibernateUtility;

public class OneToManyDaoImpl implements OneToManyDao {

	@Override
	public void addDataToParentAndItsChild() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			//set object data
			PhoneNumber ph1 = new PhoneNumber(7777777l, "prepaierd", "Airtel");
			PhoneNumber ph2 = new PhoneNumber(6666666l, "postpaid", "Vodafone");
			PhoneNumber[] phArray=new PhoneNumber[] {ph1,ph2};
			UserInfo info = new UserInfo("Aron", "africa");
			info.setPhoneDetails(phArray);
			//save data
			ses.save(info);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Object are saved");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		}

	}
	
	/*@Override
	public void deleteAchildOfCollectionOfchildOfAparent() {
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		boolean flag = false;
		
		try {
			if (!ses.getTransaction().isActive())
				tx = ses.beginTransaction();
			UserInfo user=ses.get(UserInfo.class, 1);
			PhoneNumber phArray[]=user.getPhoneDetails();
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			//perform transaction
			if (flag) {
				tx.commit();
				System.out.println("Deleted a child of collection of childs belongs to a parent");
			} else {
				tx.rollback();
				System.out.println("problem towards deleted a child");
			}
			//close session factory
			HibernateUtility.closeSessionFactory();
		}
	
		
	}
	*/
	
}
