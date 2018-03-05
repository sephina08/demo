package com.ntut.practice.demo.model.product;

import java.sql.Blob;


public class ProductFormBean {
	
	private String pName;
	private Integer pNumber;
	private double price;
	private String pDesc;
	private Integer sNumber;
	private String iName;
	private Blob pImage;
	
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getpNumber() {
		return pNumber;
	}
	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public Integer getsNumber() {
		return sNumber;
	}
	public void setsNumber(Integer sNumber) {
		this.sNumber = sNumber;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public Blob getpImage() {
		return pImage;
	}
	public void setpImage(Blob pImage) {
		this.pImage = pImage;
	}
	
}
