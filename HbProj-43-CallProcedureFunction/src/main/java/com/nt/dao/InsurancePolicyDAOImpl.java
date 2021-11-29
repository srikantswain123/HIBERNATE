package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtility;
/*CREATE OR REPLACE FUNCTION FX_INSURANCEPOLICY 
(
  ID IN NUMBER 
, PNAME OUT VARCHAR2 
, PTYPE OUT VARCHAR2 
) RETURN VARCHAR2 AS 
  duration VARCHAR2(10);
BEGIN
  select policyname,policytype,tenure into pname,ptype,duration  from insurancepolicy where policyid=Id;
  RETURN duration;
END FX_INSURANCEPOLICY;*/

public class InsurancePolicyDAOImpl implements IinsurancePolicyDAO {

	@Override
	public String[] getRsultById(final int id) {
		Session ses=null;
		Transaction tx=null;
		String result[]=null;
		//get session Object
		ses=HibernateUtility.getSession();
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		//get connetion from session Object Implemented callBack interface Returningork(i)
		result=ses.doReturningWork(new ReturningWork<String[]>() {

			@Override
			public String[] execute(Connection con) throws SQLException {
				String outputs[]=null;
				CallableStatement cs=null;
				//get callableStatement Object
				cs=con.prepareCall("{?=call FX_INSURANCEPOLICY(?,?,?)}");
				//register out/return parameter
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				//set val to in parameter
				cs.setInt(2,id);
				//exuxte procedure
				cs.execute();
				outputs=new String[3];
				outputs[0]=cs.getString(1);
				outputs[1]=cs.getString(3);
				outputs[2]=cs.getString(4);
				
				return outputs;
			}
		});
		
		
		
		return result;
	}


}
