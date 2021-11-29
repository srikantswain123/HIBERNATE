package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Address;
import com.nt.entity.Student_info;
import com.nt.utility.HibernateUtility;

public class ComponentMappingTest {

	public static void main(String[] args) {
		Session ses=null;
		Address addr=null,addr1=null;
		Student_info info=null,info1=null;
		Transaction tx=null;
		boolean flag=false;
		
		ses=HibernateUtility.getSession();
				try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
				//create data
			addr=new Address();
			addr.setCityName("canada");
			addr.setCountryName("America");
			addr.setDoorNo("1535-hfg-de");
			addr.setStreetName("jfbie");
			addr.setPin(789L);
			info=new Student_info();
			info.setSname("finch");
			info.setSavg(78);
			info.setSaddr(addr);
			
			//add second details
			addr1=new Address();
			addr1.setCityName("saudi");
			addr1.setCountryName("Abudabi");
			addr1.setDoorNo("1535-xfg-ut56-de");
			addr1.setStreetName("mhgdo");
			addr1.setPin(659L);
			info1=new Student_info();
			info1.setSname("suleman");
			info1.setSavg(98);
			info1.setSaddr(addr1);
			//save object
			ses.save(info);
			ses.save(info1);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("Object is saved");
			}else {
				tx.rollback();
				System.out.println("Object Not saved");
			}
		}//finaly

	}//main

}//class
