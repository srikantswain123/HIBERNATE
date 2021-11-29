package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.utility.MySQl_HibernateUtility;
import com.nt.utility.Oracle_HibernateUtility;

public class ProductDaoImpl implements IProductDAO {

	@Override
	public String getData(int id) {
		Session oraSes = null, mySQlSes = null;
		Product prod = null;
		Transaction oraTx = null, mySQltx = null;
		boolean flag = false;
		int pid = 0;
		// get Session Object
		oraSes = Oracle_HibernateUtility.getSession();
		mySQlSes = MySQl_HibernateUtility.getSession();
		// get Transaction Object
		oraTx = oraSes.beginTransaction();
		// get Prod Result By given I
		prod = oraSes.get(Product.class, id);
		if (prod == null)
			return "No product found by this" + id;
		else {
			try {
				mySQltx = mySQlSes.beginTransaction();
				pid=(int)mySQlSes.save(prod);
				flag=true;
			} // try
			catch (HibernateException he) {
				he.printStackTrace();
				flag=false;
			}
			// try
			finally {
				if(flag) {
					mySQltx.commit();
					
				}
				else {
					mySQltx.rollback();
					
				}

			} // finally
			return "Object Copied From  One db To Anther Db"+pid;
		} // else

	}//get

}//class
