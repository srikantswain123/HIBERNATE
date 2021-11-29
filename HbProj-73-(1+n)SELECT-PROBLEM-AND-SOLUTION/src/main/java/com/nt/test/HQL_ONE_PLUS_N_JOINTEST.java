package com.nt.test;

import com.nt.dao.OneToManyDao;
import com.nt.dao.OneToManyDaoImpl;

public class HQL_ONE_PLUS_N_JOINTEST {

	public static void main(String[] args) {
		OneToManyDao dao=new OneToManyDaoImpl();
		//dao.selectDataParentToChildONE_NProblem();
		dao.HBQBC_one_plus_n_solution();
		//dao.JPAQBC_one_plus_n_solution();
		//dao.FETCH_HQL_JOIN_solution();
		//dao.HQL_SCALLAR_solution();
	}

}
