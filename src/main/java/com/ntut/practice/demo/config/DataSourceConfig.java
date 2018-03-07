package com.ntut.practice.demo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	//設定連線資訊
	@Bean
	public DataSource jdbcDataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/zoo");
		ds.setConnectionProperties("useSSL=true;useUnicode=yes;characterEncoding=utf8");
		ds.setUsername("admin");
		ds.setPassword("1a2b");
		return ds;
	}
}
