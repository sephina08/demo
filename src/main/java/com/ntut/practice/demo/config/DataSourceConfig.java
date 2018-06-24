package com.ntut.practice.demo.config;

import com.ntut.practice.demo.config.prop.JdbcConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.ntut.practice.demo.dao")
public class DataSourceConfig {

    @Autowired
    private JdbcConfig jdbcConfig;

    /**
     * 設定連線資訊，資料源 {@link com.ntut.practice.demo.config.prop.JdbcConfig}
     *
     * @return
     */
    @Bean
    public DataSource jdbcDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(jdbcConfig.getDriverClassName());
        ds.setUrl(jdbcConfig.getUrl());
        ds.setConnectionProperties(jdbcConfig.getConnectionProperties());
        ds.setUsername(jdbcConfig.getUserName());
        ds.setPassword(jdbcConfig.getPassword());
        return ds;
    }
}
