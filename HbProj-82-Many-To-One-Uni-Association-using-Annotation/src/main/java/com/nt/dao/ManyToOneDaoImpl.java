package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Company;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtility;

public class ManyToOneDaoImpl implements IManyToOneDao{
	@Override
	public void saveObject() {
	//get session Object
		Session ses=HibernateUtility.getSession();
		Transaction tx=null;
		boolean flag=false;
		//create company ane employee Object
		Company hcl=new Company("HCL", "HYDERBAD", "JAVA,.NET,PHP,PYTHON");
		Employee Hclemp1=new Employee("rajat", "mumbai", "java");
		Employee Hclemp2=new Employee("milind", "gurdaspur", "python");
		Hclemp1.setCompany(hcl);
		Hclemp2.setCompany(hcl);
		
		//second company employee
		
		Company oracle=new Company("ORACLE", "AMERICA", "JAVA,ORACLE");
		Employee oraemp1=new Employee("finch", "canda", "oracle");
		Employee oraemp2=new Employee("smith", "washington-dc", "java");
		oraemp1.setCompany(oracle);
		oraemp2.setCompany(oracle);
		
		//begintransaction
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		try {
			//save object using Employee
			ses.save(Hclemp1);ses.save(Hclemp2);ses.save(oraemp1);ses.save(oraemp2);
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
				System.out.println("Object Not Saved");
			}
		}//finally
		
		
	}//method

}//class
