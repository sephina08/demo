package com.ntut.practice.demo.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ntut.practice.demo.dao.BaseDao;
import com.ntut.practice.demo.model.member.CityBean;

@Repository
public class CityDao extends BaseDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(CityDao.class);
	private String getAllCity = "SELECT * FROM CITY";

	public List<CityBean> getAllCity() {
		List<CityBean> list = new ArrayList<>();
		try (Connection conn = getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(getAllCity);) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CityBean cityBean = new CityBean();
				cityBean.setCityOid(rs.getInt("city_OID"));
				cityBean.setCityName(rs.getString("city_name"));
				list.add(cityBean);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}

		return list;

	} 

	
	
	
	
}
