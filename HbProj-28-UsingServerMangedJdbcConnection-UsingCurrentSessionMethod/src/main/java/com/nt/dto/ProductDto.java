package com.nt.dto;

import java.io.Serializable;
public class ProductDto implements Serializable {
	private Integer pid;
	private String pidname;
	private Float price;
	private Integer qty;
	private String startegy;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPidname() {
		return pidname;
	}
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public String getStartegy() {
		return startegy;
	}
	public void setStartegy(String startegy) {
		this.startegy = startegy;
	}
	@Override
	public String toString() {
		return "ProductDto [pid=" + pid + ", pidname=" + pidname + ", price=" + price + ", qty=" + qty + ", startegy="
				+ startegy + "]";
	}
	

}
