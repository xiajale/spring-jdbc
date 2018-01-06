package com.xidian.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by zhouyibin on 2018/1/6.
 */
@Configuration
@EnableTransactionManagement
public class BeanConfig {

    private final Environment env;

    @Autowired
    public BeanConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "oneDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.one")
    public DataSource oneDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "twoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource twoDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "oneJdbcTemplate")
    public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "twoJdbcTemplate")
    public JdbcTemplate twoJdbcTemplate(@Qualifier("twoDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
