package com.ntut.practice.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao {
	@Autowired
	private DataSource ds;
	
	protected Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
