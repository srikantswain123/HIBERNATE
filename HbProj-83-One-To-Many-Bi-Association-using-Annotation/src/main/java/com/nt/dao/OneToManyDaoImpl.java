package com.nt.dao;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MobileBrand;
import com.nt.entity.MobileModel;
import com.nt.utility.HibernateUtility;

public class OneToManyDaoImpl implements IOneToManyDao {

	@Override
	public void saveObjectUsingParent() {
		//get session object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//create Mobile Brand object
		MobileBrand brands[]= {new MobileBrand("APPLE", LocalDate.of(2007, 06, 29), "USA"),
				               new MobileBrand("SAMSUNG", LocalDate.of(1993, 06, 04), "SOUTH-KOREA"),
				               new MobileBrand("ONEPLUS", LocalDate.of(2014, 04, 23), "CHINA")};
		//Create model object
		MobileModel apple[]= {new MobileModel("Iphone4", LocalDate.of(2010, 06, 24)),
				              new MobileModel("Iphone5s", LocalDate.of(2013, 9, 20)),
				              new MobileModel("Iphone12", LocalDate.of(2020, 10, 13))};
		
		MobileModel samsung[]= {new MobileModel("samsung-s3", LocalDate.of(2012, 05, 29)),
	              new MobileModel("samsung-s5", LocalDate.of(2014, 04, 11)),
	              new MobileModel("samsung-galaxy-z", LocalDate.of(2020, 02, 20))};
		
		MobileModel oneplus[]= {new MobileModel("OnePlus-Nord-N10", LocalDate.of(2020, 12, 10)),
	              new MobileModel("OnePlus-9", LocalDate.of(2020, 12, 24)),
	              new MobileModel("OnePlus-z", LocalDate.of(2020, 12, 23))};
		
		brands[0].setModels(Set.of(apple[0],apple[1],apple[2]));
		brands[1].setModels(Set.of(samsung[0],samsung[1],samsung[2]));
		brands[2].setModels(Set.of(oneplus[0],oneplus[1],oneplus[2]));
		
		for(MobileModel app:apple) {
			app.setBrand(brands[0]);
		}
		for(MobileModel sam:samsung) {
			sam.setBrand(brands[1]);
		}
		for(MobileModel one:oneplus) {
			one.setBrand(brands[2]);
		}
		
		try {
			//begin transaction
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//save Object using parent Object
			for(MobileBrand brand:brands) {
				ses.save(brand);
			}
		     flag=true;
		
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			//perfrom transaction
			if(flag) {
				tx.commit();
				System.out.println("Object saved using parent");
			}else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}//finally

	}//method
	
	@Override
	public void saveObjectUsingChild() {
		//get session object
				Session ses=HibernateUtility.getSession();
				Transaction tx=null;
				boolean flag=false;
				//create Mobile Brand object
				MobileBrand brands[]= {new MobileBrand("NOKIA", LocalDate.of(2007, 06, 29), "CHINA"),
						               new MobileBrand("XIAOMI", LocalDate.of(1993, 06, 04), "CHINA"),
						               new MobileBrand("VIVO", LocalDate.of(2014, 04, 23), "CHINA")};
				//Create model object
				MobileModel models[][]= {{new MobileModel("LUMIA820", LocalDate.of(2010, 06, 24)),
						                  new MobileModel("LUMIA920", LocalDate.of(2013, 9, 20)),
						                  new MobileModel("LUMIA1010", LocalDate.of(2020, 10, 13))},  //[0]
						                 {new MobileModel("MI13", LocalDate.of(2012, 05, 29)),
							              new MobileModel("MI-6", LocalDate.of(2014, 04, 11)),
							              new MobileModel("MI-NOTE-10", LocalDate.of(2020, 02, 20))}, //[1]
						                 {new MobileModel("VIVO-V1", LocalDate.of(2020, 12, 10)),
								          new MobileModel("VIVO-V7", LocalDate.of(2020, 12, 24)),
								          new MobileModel("VIVO-V9", LocalDate.of(2020, 12, 23))}};      //[2]
                  //set model to brand
					brands[0].setModels(Set.of(models[0][0],models[0][1],models[0][2]));
					brands[1].setModels(Set.of(models[1][0],models[1][1],models[1][2]));
					brands[2].setModels(Set.of(models[2][0],models[2][1],models[2][2]));
				
				//set brand to model
				
				for(MobileModel[] model:models) {
					model[0].setBrand(brands[0]);
					model[1].setBrand(brands[1]);
					model[2].setBrand(brands[2]);
				}
				try {
					//begin transaction
					if(!ses.getTransaction().isActive())
						tx=ses.beginTransaction();
					//save Object using child Object
                     for(MobileModel[] model:models) {
                    	 for(MobileModel mod:model) {
                    		 ses.save(mod);
                    	 }//for
                     }//for
				     flag=true;
				}catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}finally {
					//perfrom transaction
					if(flag) {
						tx.commit();
						System.out.println("Object saved using child");
					}else {
						tx.rollback();
						System.out.println("Objects are not saved");
					}
				}//finally

		
	}

}//class
