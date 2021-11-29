package com.nt.dao;

public interface IManyToOneDao {
	public void saveManyToOne();
	public void selectDataUsingChild();
	public void deleteOneChildFromCollectionOfChildOfAparent();
}
