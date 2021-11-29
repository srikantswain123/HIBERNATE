package com.nt.dao;

public interface OneToManyDao {
	public void addDataToParentAndItsChild();
	public void selectParentDataAndTheirChild();
	public void addDataOnExstingParentAndItsChild();
	public void deleteAparentAndItsChild();
	public void deleteDataOfParentAndTheirChild();
	public void deleteAllChildsOfAParent();
	public void deleteOneChildFromCollectionOfChildOfA_Parent();
	public void transferOneChildOfAparentToAnotherParent();

}
