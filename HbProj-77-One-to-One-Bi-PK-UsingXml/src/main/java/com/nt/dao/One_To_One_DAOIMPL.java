package com.nt.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.LibraryMgmt;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtility;

public class One_To_One_DAOIMPL implements IOne_To_OneDAO {

	@Override
	public void saveObjectUsingParent() {
		//get sesssion object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		boolean flag=false;
		try {
			//create Student Object
			Student st=new Student("raja","hyd");
			//create library Object
			LibraryMgmt mgmt=new LibraryMgmt("god", LocalDate.of(2020, 12, 23), LocalDate.of(2030, 12, 23));
			
			//set both association Object
			st.setLibrary(mgmt);
			mgmt.setStudentDetails(st);
			//save Object Using Parent Object
			ses.save(st);
			flag=true;
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			//perform transaction
			if(flag) {
				tx.commit();
				System.out.println("Object saved");
			}else {
				tx.rollback();
				System.out.println("Object not saved");
			}
		}//finally

	}//method
	@Override
	public void saveObjectUsingChild() {
		//get sesssion object
				Session ses=HibernateUtility.getSession();
				Transaction tx=null;
				if(!ses.getTransaction().isActive())
					tx=ses.beginTransaction();
				boolean flag=false;
				try {
					//create Student Object
					Student st=new Student("mahesh","mumbai");
					//create library Object
					LibraryMgmt mgmt=new LibraryMgmt("silver", LocalDate.of(2020, 12, 23), LocalDate.of(2030, 12, 23));
					
					//set both association Object
					st.setLibrary(mgmt);
					mgmt.setStudentDetails(st);
					//save Object Using Child Object
					ses.save(mgmt);
					flag=true;
				}catch(HibernateException he) {
					he.printStackTrace();
					flag=false;
				}finally {
					//perform transaction
					if(flag) {
						tx.commit();
						System.out.println("Object saved");
					}else {
						tx.rollback();
						System.out.println("Object not saved");
					}
				}//finally
		
	}//method
	@Override
	public void loadObjectUsingParent() {
		//get sesssion object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		try {
			//load object using hql
			Query query=ses.createQuery("From Student");
			List<Student> list=query.getResultList();
			list.forEach(student->{
				System.out.println("Parent ::"+student);
				LibraryMgmt mgmt=student.getLibrary();
				System.out.println("child ::"+mgmt);
				
			});
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			//close session facrtory
			HibernateUtility.closeSessionFactory();
		}//finally
		
	}

}//class
