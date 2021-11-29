package com.nt.factory;

import com.nt.componet.Amazon;
import com.nt.componet.EcomerseStore;
import com.nt.proxy.EcomerseProxy;

public class EcomerseFactory {

	public static  EcomerseStore getInstance(String coupon) {
	if(coupon.equalsIgnoreCase("")||coupon.trim().length()==0)	{
		return new Amazon();
	}else {
		if(coupon.equalsIgnoreCase("AM10"))
			return new EcomerseProxy(10);
		else if(coupon.equalsIgnoreCase("Am20"))
			return new EcomerseProxy(20);
		else
			return new EcomerseProxy(5);
	}
		
		
	}

}
