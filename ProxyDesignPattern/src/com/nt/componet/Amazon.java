package com.nt.componet;

import java.util.stream.DoubleStream;

public class Amazon implements EcomerseStore {

	@Override
	public double shoping(String[] items, double[] amt) {
		double totalAmt=0.0;
		totalAmt=DoubleStream.of(amt).sum();
		return totalAmt;
	}

}
