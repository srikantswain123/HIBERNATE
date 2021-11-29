package com.nt.proxy;

import com.nt.componet.Amazon;
import com.nt.componet.EcomerseStore;

public class EcomerseProxy implements EcomerseStore {
	private int discout;
	Amazon amaz=null;
	

	public EcomerseProxy(int discout) {
		this.discout = discout;
		amaz=new Amazon();
	}


	@Override
	public double shoping(String[] items, double[] amt) {
		double amts=0.0;
		double totalAmt=0.0;
		amts=amaz.shoping(items, amt);
        totalAmt=amts-(amts*discout/100);
		return totalAmt;
	}

}
