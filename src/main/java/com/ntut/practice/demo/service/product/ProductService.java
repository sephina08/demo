package com.ntut.practice.demo.service.product;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntut.practice.demo.dao.product.IProductDAO;
import com.ntut.practice.demo.dao.product.ProductDAO;
import com.ntut.practice.demo.model.product.ProductBean;
import com.ntut.practice.demo.model.product.ProductFormBean;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	@Autowired ProductBean bean;
	//controller直接呼叫DAO資料結構會外洩,Service也不能資料結構外洩,所以使用MemberForBean去setProductBean
	public void insertProduct(ProductFormBean ProductFormBean){
		bean.setProductName(ProductFormBean.getpName());
		bean.setProductNumber(ProductFormBean.getpNumber());
		bean.setPrice(ProductFormBean.getPrice());
		bean.setProductDesc(ProductFormBean.getpDesc());
		bean.setStockNumber(ProductFormBean.getsNumber());
		bean.setImageName(ProductFormBean.getiName());
		bean.setProductImage(ProductFormBean.getpImage());
		bean.setImageName(ProductFormBean.getiName());
		
		productDAO.insertProduct(bean);
	}
	public Map<String,String> check(ProductFormBean bean){
		Map<String,String> errorMessage = new HashMap<>();
		
		String pName = bean.getpName();
		if(pName == null || pName.trim().length() == 0){
			errorMessage.put("pName", "必須輸入商品名稱");
		}
		Integer pNumber = bean.getpNumber();
		if(pNumber == null){
			errorMessage.put("pNumber", "必須輸入商品數量");
		}
		Double price = bean.getPrice();
		if(price == null || price == 0){
			errorMessage.put("price", "商品價格不能為零或空白");
		}
		String pDesc = bean.getpDesc();
		if(pDesc == null || pDesc.trim().length() == 0){
			errorMessage.put("pDesc", "必須輸入商品名稱");
		}
		Integer sNumber = bean.getsNumber();
		if(sNumber == null){
			errorMessage.put("sNumber", "必須輸入圖片名稱");
		}
		Blob pImage = bean.getpImage();
		if(pImage == null){
			errorMessage.put("pImage","請上傳商品照片");
		}
		
		
		return errorMessage;
	}
}
