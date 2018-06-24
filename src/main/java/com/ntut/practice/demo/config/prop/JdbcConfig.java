package com.ntut.practice.demo.config.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties 上的值參考到 application.yml 的 jdbc 資料
 */
@Component
@ConfigurationProperties("jdbc")
@Getter
@Setter
public class JdbcConfig {
    private String driverClassName;
    private String url;
    private String connectionProperties;
    private String userName;
    private String password;
}
