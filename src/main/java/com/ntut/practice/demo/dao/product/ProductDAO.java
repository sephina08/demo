package com.ntut.practice.demo.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.product.ProductBean;

public class ProductDAO extends BaseDao implements  IProductDAO{
	private String INSERTSQL = "INSERT INTO PRODUCT "
							+ "(PD_Name , PD_Number , "
							+ " PD_Price , PD_Desc , PD_Stock , "
							+ " PD_Pic , PD_Image )"
							+ "value (?,?,?,?,?,?,?)";
	@Override
	public void insertProduct(ProductBean bean) {
		
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERTSQL);
		
			stmt.setString(1,bean.getProductName());
			stmt.setInt(2, bean.getProductNumber());
			stmt.setDouble(3, bean.getPrice());
			stmt.setString(4, bean.getProductDesc());
			stmt.setInt(5, bean.getStockNumber());
			stmt.setString(6, bean.getImageName());
			stmt.setBlob(7, bean.getProductImage());
			stmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	}

	

}
