package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Department;
import com.nt.entity.EmployeeDetails;
import com.nt.utility.HibernateUtility;

public class ManyToOneDaoImpl implements IManyToOneDao {

	@Override
	public void saveManyToOne() {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//create Parent Object
			Department dept=new Department( "IT", "MUMBAI",20);
			//create child object many to one uni directional
			EmployeeDetails details[]=new EmployeeDetails[] {new EmployeeDetails("raja",70000.0f,dept),new EmployeeDetails("ramesh",80000.0f,dept),new EmployeeDetails("rahul",90000.0f,dept)};
		for(EmployeeDetails detail:details) {
			ses.save(detail);
			flag=true;
		}
		}catch(HibernateException he) {
			he.printStackTrace();
			flag=false;
		}finally {
			//perform trnsaction
			if(flag) {
				tx.commit();
				System.out.println("Many To One Object saved");
			}else {
				tx.rollback();
				System.out.println("Many To One Object not svaed");
			}
		}//finally

	}//method
	
	
	@Override
	public void selectDataUsingChild() {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
		Query<EmployeeDetails> query=ses.createQuery("from EmployeeDetails");
		List<EmployeeDetails> list=query.getResultList();
		list.forEach(emp->{
			System.out.println("Child::"+emp.getEmpName()+" "+emp.getEmpRegno()+" "+emp.getEmpSal());
		});
		}catch(HibernateException he) {
			he.printStackTrace();
		}finally {
			//close session factory
			HibernateUtility.closeSessionFactory();
			
		}//finally

	}//method
	
	
	//here multiple child object associate with one parent then ses.delete() method we can't use it throws sql integrity exception"--ITS BAD APPROACH--"
	/*@Override
	public void deleteOneChildFromCollectionOfChildOfAparent() {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//delete record using regno
			EmployeeDetails emp=ses.get(EmployeeDetails.class, 2);
			ses.delete(emp);
			flag=true;
		}catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("Child And Its Parent Object deleted");
				}else {
					tx.rollback();
					System.out.println("Problem toards Delted Record");
				}
			
			//close session factory
			HibernateUtility.closeSessionFactory();
			
		}//finally
		
	}*/
	public void deleteOneChildFromCollectionOfChildOfAparent() {
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		try {
			if(!ses.getTransaction().isActive())
				tx=ses.beginTransaction();
			//delete record using regno
			Query query=ses.createQuery("DELETE FROM EmployeeDetails where empRegno=:no" );
			query.setParameter("no", 2);
			query.executeUpdate();
			flag=true;
		}catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("Child  Object deleted");
				}else {
					tx.rollback();
					System.out.println("Problem towards Delted Record");
				}
			
			//close session factory
			HibernateUtility.closeSessionFactory();
			
		}//finally
		
	}//method
	
	

}//class
