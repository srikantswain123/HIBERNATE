package com.nt.test;

import com.nt.componet.EcomerseStore;
import com.nt.factory.EcomerseFactory;

public class Test {
	public static void main(String[] args) {
		EcomerseStore store=EcomerseFactory.getInstance("Am10");
		System.out.println(store.shoping(new String[] {"rakhsi", "sweet","chocalte"},new double[] {100,200,500}));
		System.out.println(store.getClass());
		store=EcomerseFactory.getInstance("");
		System.out.println(store.shoping(new String[] {"haladi","lankagunda","dhniapatra"},new double[] {500,200,900}));
	    System.out.println(store.getClass());
	}

}
