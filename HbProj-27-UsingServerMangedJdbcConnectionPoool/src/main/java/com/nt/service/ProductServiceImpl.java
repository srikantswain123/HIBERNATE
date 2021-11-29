package com.nt.service;

import com.nt.dao.ProductDao;
import com.nt.dao.ProductDaoImpl;
import com.nt.dto.ProductDto;
import com.nt.entity.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao dao;
	public ProductServiceImpl() {
		dao=new ProductDaoImpl();
	}
	@Override
	public ProductDto fetchData(int pid) {
		ProductDto dto=null;
		Product prod=null;
		prod=dao.getData(pid);
		if(prod!=null) {
		dto=new ProductDto();
		dto.setPid(prod.getPid());
		dto.setPidname(prod.getPidname());
		dto.setPrice((float)Math.round(prod.getPrice()));
		dto.setQty(Math.round(prod.getQty()));
		if(dto.getPrice()>=1500) {
			dto.setStartegy("premium");
		}else {
			dto.setStartegy("Affordable Product");
		}
		}
		return dto;
	}

}
