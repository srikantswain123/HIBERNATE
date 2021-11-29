package com.nt.dao;
/*CREATE OR REPLACE PROCEDURE P_AUTHENTICATION 
(
  USERNAME IN VARCHAR2 
, PASSWORD IN VARCHAR2 
, RESULT OUT VARCHAR2 
) AS 
 val NUMBER;
BEGIN
  select count(*)into val from userinfo where uname=username and password=pwd;
  if(val<>0)then
    result:='valid credential';
    else
    result:='invalid credential';
    end if;
END P_AUTHENTICATION;*/

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;

import com.nt.utility.HibernateUtility;

public class AuthenticationDaoImpl implements IAuthenticationDAO {

	@Override
	public String verfiCredential(String username, String password) {
		Session ses=null;
		Transaction tx=null;
		ProcedureCall call=null;
		String result=null;
		//get Sessio Object
		ses=HibernateUtility.getSession();
		//create Dummy transaction
		if(!ses.getTransaction().isActive())
			tx=ses.beginTransaction();
		call=ses.createStoredProcedureCall("P_AUTHENTICATION");
         //register in out Parameter
		call.registerParameter(1, String.class, ParameterMode.IN).bindValue(username);
		call.registerParameter(2, String.class, ParameterMode.IN).bindValue(password);
		call.registerParameter(3, String.class, ParameterMode.OUT);
		 
		result=(String) call.getOutputParameterValue(3);
		
		return result;
	}

}
