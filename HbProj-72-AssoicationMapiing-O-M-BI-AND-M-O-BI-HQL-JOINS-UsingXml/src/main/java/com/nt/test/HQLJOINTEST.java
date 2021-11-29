package com.nt.test;

import com.nt.dao.OneToManyDao;
import com.nt.dao.OneToManyDaoImpl;

public class HQLJOINTEST {

	public static void main(String[] args) {
		OneToManyDao dao=new OneToManyDaoImpl();
		//dao.selectDataParentToChild();
		dao.selectDatachildToParent();
	}

}
