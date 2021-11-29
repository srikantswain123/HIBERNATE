package com.nt.test;

import com.nt.dao.OneToManyDao;
import com.nt.dao.OneToManyDaoImpl;

public class OneToManyRelationTest {

	public static void main(String[] args) {
		OneToManyDao dao=new OneToManyDaoImpl();
		//dao.addDataToParentAndItsChild();
		//dao.selectParentDataAndTheirChild();
		//dao.addDataOnExstingParentAndItsChild();
		//dao.deleteAparentAndItsChild();
		//dao.deleteDataOfParentAndTheirChild();
        //dao.deleteAllChildsOfAParent();
		dao.deleteOneChildFromCollectionOfChildOfA_Parent();
		//dao.transferOneChildOfAparentToAnotherParent();
	}

}
