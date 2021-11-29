package com.nt.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.result.Output;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtility;

/*CREATE OR REPLACE PROCEDURE P_INSURANCEPOLICY_BY_TENURE 
(
  MINTENURE IN NUMBER 
, MAXTENURE IN NUMBER 
, DETAILS OUT SYS_REFCURSOR 
) AS 
BEGIN
   OPEN DETAILS FOR
   SELECT POLICYID,POLICYNAME,COMPANY,POLICYTYPE,TENURE FROM insurancepolicy WHERE TENURE>=mintenure AND TENURE<=maxtenure;

END P_INSURANCEPOLICY_BY_TENURE;*/

public class InsurancePolicyDAOImpl implements IinsurancePolicyDAO {

	@Override
	public List<InsurancePolicy> getResultsByTenure(int start, int end) {
		Session ses = null;
		Transaction tx = null;
		ProcedureCall call = null;
		Output out = null;
		ResultSetOutput rsOut = null;
		//get session Object
		ses = HibernateUtility.getSession();
		if (!ses.getTransaction().isActive())
			tx = ses.beginTransaction();
		call = ses.createStoredProcedureCall("P_INSURANCEPOLICY_BY_TENURE", InsurancePolicy.class);
		call.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(start);
		call.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(end);
		call.registerParameter(3, Class.class, ParameterMode.REF_CURSOR);
		out = call.getOutputs().getCurrent();
		rsOut = (ResultSetOutput) out;

		return rsOut.getResultList();
	}

}
