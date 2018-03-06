package com.ntut.practice.demo.service.product;

import com.ntut.practice.demo.dao.product.ProductDAO;
import com.ntut.practice.demo.model.product.ProductBean;
import com.ntut.practice.demo.model.product.ProductFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductDAO productDAO;

    // controller直接呼叫DAO資料結構會外洩,Service也不能資料結構外洩,所以使用MemberForBean去setProductBean
    public void insertProduct(ProductFormBean ProductFormBean) {

        ProductBean bean = new ProductBean();
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

    //	public Map<String, String> check(ProductFormBean bean) {
//		Map<String, String> errorMessage = new HashMap<>();
//		System.out.println("service check start check!");
//		String pName = bean.getpName();
//		if (pName == null || pName.trim() == "") {
//			errorMessage.put("pName", "必須輸入商品名稱");
//		}
//		Integer pNumber = bean.getpNumber();
//		if (pNumber == null) {
//			errorMessage.put("pNumber", "必須輸入商品數量");
//		}
//		Double price = bean.getPrice();
//		if (price == null) {
//			errorMessage.put("price", "商品價格不能為零或空白");
//		}
//		
//		
//		String pDesc = bean.getpDesc();
//		if (pDesc == null || pDesc.trim().length() == 0) {
//			errorMessage.put("pDesc", "必須輸入商品名稱");
//		}
//		
//		Integer sNumber = bean.getsNumber();
//		if (sNumber == null) {
//			errorMessage.put("sNumber", "必須輸入商品庫存");
//		}
//		
//		String iName = bean.getiName();
//		if (iName == null || iName.trim().length() == 0) {
//			errorMessage.put("sNumber", "必須輸入圖片名稱");
//		}
//		String pImage = bean.getpImage();
//		if (pImage == null) {
//			errorMessage.put("pImage", "請上傳商品照片");
//		}
//		System.out.println("service check end check!");
//
//		return errorMessage;
//	}
    public Map<String, String> check(String productName, String productNumber, String price, String productDesc, String stockNumber,
                                     String imageName/*,  String productImage*/) {
        Map<String, String> errorMessage = new HashMap<>();
        System.out.println("service check start check!");

        if (productName == null || productName.trim().length() == 0) {
            errorMessage.put("pName", "必須輸入商品名稱");
        }
        if (productNumber == null || productNumber.trim().length() == 0) {
            errorMessage.put("pNumber", "必須輸入商品數量");
        }
        if (price == null || price.trim().length() == 0) {
            errorMessage.put("price", "必須輸入商品價格");
        }
        if (productDesc == null || productDesc.trim().length() == 0) {
            errorMessage.put("pDesc", "必須輸入商品說明");
        }

        if (stockNumber == null || stockNumber.trim().length() == 0) {
            errorMessage.put("sNumber", "必須輸入庫存數量");
        }

        if (imageName == null || imageName.trim().length() == 0) {
            errorMessage.put("iName", "必須輸入圖片名稱");
        }
//		if (productImage == null ) {
//			errorMessage.put("pImage", "必須上傳商品照片");
//		}


        return errorMessage;
    }

    public ProductFormBean errorNull(String productName, String productNumber,
                                     String price, String productDesc, String stockNumber,
                                     String imageName/*,  String productImage*/) {
        ProductFormBean bean = new ProductFormBean();
//			ProductFormBean bean = new ProductFormBean(productName, Integer.parseInt(productNumber),
//					Double.parseDouble(price), productDesc, Integer.parseInt(stockNumber),imageName);


        bean.setiName(productName);
        bean.setsNumber(Integer.parseInt(productNumber));
        bean.setPrice(Double.parseDouble(price));
        bean.setpDesc(productDesc);
        bean.setsNumber(Integer.parseInt(stockNumber));
        bean.setpImage(imageName);
//		bean.setpImage();


        return bean;
    }


}
