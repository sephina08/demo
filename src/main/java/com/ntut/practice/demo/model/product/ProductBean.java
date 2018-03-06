package com.ntut.practice.demo.model.product;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class ProductBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer productNumber;
	private String productName;
	private Integer stockNumber;
	private String productDesc;
	private double price;
	private String imageName;
	private String software;
	private Clob softDesc;
	private String productImage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(Integer productNumber) {
		this.productNumber = productNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getStockNumber() {
		return stockNumber;
	}
	public void setStockNumber(Integer stockNumber) {
		this.stockNumber = stockNumber;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getSoftware() {
		return software;
	}
	public void setSoftware(String software) {
		this.software = software;
	}
	public Clob getSoftDesc() {
		return softDesc;
	}
	public void setSoftDesc(Clob softDesc) {
		this.softDesc = softDesc;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	

	
}
