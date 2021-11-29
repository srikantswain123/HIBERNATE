package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.CarCompany;
import com.nt.entity.CarModel;
import com.nt.utility.HibernateUtility;

public class One_To_Many_DAO_IMPL implements IOne_To_Many_Dao_UNI {

	@Override
	public void saveObjectUsingParent() {
		// get session Object
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		boolean flag = false;
		try {
			// prepare child object
			CarModel model = new CarModel("baleno", "hatch pack", "deisel");
			CarModel model1 = new CarModel("innova", "suv", "petrol");
			// create Parent Object
			CarCompany comp = new CarCompany("maruti", "noida");
			// set asoociate child object
			comp.setModel(List.of(model, model1));
			// save object using parent
			ses.save(comp);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				tx.commit();
				System.out.println("objects are savde");
			} else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		} // finally

	}// method
	
	

}// class
