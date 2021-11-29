package com.nt.dao;

public interface IManyToMayDao {
	public void saveObjectUsingParent();
	public void saveObjectUsingChild();
	public void  selectDataUsingParent();
	public void selectDataUsingChild();
	public void deleteAllcchildsOfAParent();
	public void deleteAchildOfAParent();

}
