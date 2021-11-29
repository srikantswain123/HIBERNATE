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
			comp.setModel(Set.of(model, model1));
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
	
	@Override
	public void loadDataUsingParent() {
		// get session Object
				Session ses = HibernateUtility.getSession();
				Transaction tx = null;
				if (!ses.getTransaction().isActive())
					tx = ses.beginTransaction();
				try {
					//load objecct using parent
					Query query=ses.createQuery("FROM com.nt.entity.CarCompany");
					List<CarCompany> list=query.getResultList();
					list.forEach(comapny->{
						System.out.println("Parent::"+comapny);
						Set<CarModel> set=comapny.getModel();
						System.out.println(set.isEmpty());
						/*set.forEach(model->{
							System.out.println("child::"+model);
						});*/
					});
				} catch (HibernateException he) {
					he.printStackTrace();
				} 
		
	}//method
	@Override
	public void loadDataUsingParentQBC() {
		// get session Object
		Session ses = HibernateUtility.getSession();
		Transaction tx = null;
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		try {
			//load objecct using parent
			Criteria criteria=ses.createCriteria(CarCompany.class);
			List<CarCompany> list=criteria.list();
			list.forEach(comapny->{
				System.out.println("Parent::"+comapny);
				Set<CarModel> set=comapny.getModel();
				System.out.println(set.isEmpty());
				set.forEach(model->{
					System.out.println("child::"+model);
				});
			});
		} catch (HibernateException he) {
			he.printStackTrace();
		} 
	}
	@Override
	public void deleteOneChildOfCollectionOfChildsBelngingAParent() {
		// get session Object
				Session ses = HibernateUtility.getSession();
				Transaction tx = null;
				var flag=false;
				if (!ses.getTransaction().isActive())
					tx = ses.beginTransaction();
				try {
					//load parent
					CarCompany company=ses.get(CarCompany.class, 143);
					//load its all child
					Set<CarModel> models=company.getModel();
					//load specfic child from db
					CarModel model=ses.get(CarModel.class, 21);
					models.remove(model);
					flag=true;
				} catch (HibernateException he) {
					he.printStackTrace();
					flag=false;
				} finally {
					if(flag) {
						tx.commit();
						System.out.println("Object deleted");
					}else {
						tx.rollback();
						System.out.println("Object Not delted");
					}
				}//finally
		
	}//method

}// class
