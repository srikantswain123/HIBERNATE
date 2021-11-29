package com.nt.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Subscriber;
import com.nt.entity.TvChannels;
import com.nt.utility.HibernateUtility;

public class ManyToManyDaoImpl implements IManyToManyDao {

	@Override
	public void saveObjectUsingParent() {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//create subscriber Object
		Subscriber raja=new Subscriber("raja", "silver", "hyd");
		Subscriber mahesh=new Subscriber("mahesh", "gold", "delhi");
		Subscriber rohit=new Subscriber("rohit", "gold", "mumbai");
		//create TvChanel Object
		TvChannels star=new TvChannels("star", "star india", "india");
		TvChannels zee=new TvChannels("zee", "zee parivar", "india");
		
		//set c to p and p to c
		star.setSubscribers(Set.of(mahesh,rohit));
		zee.setSubscribers(Set.of(raja,rohit));

		raja.setChanels(Set.of(zee));
		mahesh.setChanels(Set.of(star));
		rohit.setChanels(Set.of(star,zee));
		//begin transaction
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//save object
			ses.save(star);
			ses.save(zee);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			//perform transaction
			if(flag) {
				tx.commit();
				System.out.println("Object are Saved");
			}else {
				tx.rollback();
				System.out.println("Objects are not saved");
			}
		}
	}//method

}//class
