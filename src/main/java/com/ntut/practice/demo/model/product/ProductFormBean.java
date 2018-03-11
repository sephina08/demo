package com.ntut.practice.demo.model.product;

public class ProductFormBean {
	
	private String pName;
	private Integer pNumber;
	private double price;
	private String pDesc;
	private Integer sNumber;
	private String iName;
	private String pImage;
	
	public ProductFormBean() {
		super();
	}
	public ProductFormBean(String pName, Integer pNumber, double price, String pDesc, Integer sNumber, String iName) {
		super();
		this.pName = pName;
		this.pNumber = pNumber;
		this.price = price;
		this.pDesc = pDesc;
		this.sNumber = sNumber;
		this.iName = iName;
	}
	public ProductFormBean(String pName, Integer pNumber, double price, String pDesc, Integer sNumber, String iName,
			String pImage) {
		super();
		this.pName = pName;
		this.pNumber = pNumber;
		this.price = price;
		this.pDesc = pDesc;
		this.sNumber = sNumber;
		this.iName = iName;
		this.pImage = pImage;
	}
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
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	
	
	
	
	
}
