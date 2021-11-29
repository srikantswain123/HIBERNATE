package com.nt.dao;

public interface IOne_To_Many_Dao_UNI {
	public void saveObjectUsingParent();
	public void loadDataUsingParent();
	public void loadDataUsingParentQBC();
	public void deleteOneChildOfCollectionOfChildsBelngingAParent();

}
