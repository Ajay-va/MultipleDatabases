package com.multiple.databases.config;

import com.zaxxer.hikari.util.DriverDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.multiple.databases.repositories1"},
        entityManagerFactoryRef = "entityManagerFactoryBean",
        transactionManagerRef = "transactionManager"
)
public class DatabaseConfigOne {

    @Autowired
    private Environment environment;

    @Bean
    @Primary
    public DataSource dataSource(){

        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("spring.datasource.one.url"));
        dataSource.setDriverClassName(environment.getProperty("spring.datasource.one.driverClassName"));
        dataSource.setUsername(environment.getProperty("spring.datasource.one.username"));
        dataSource.setPassword(environment.getProperty("spring.datasource.one.password"));


        return dataSource;
    }

    @Bean("entityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){


        LocalContainerEntityManagerFactoryBean local=new LocalContainerEntityManagerFactoryBean();

        JpaVendorAdapter jpaVendorAdapter=new HibernateJpaVendorAdapter();
        local.setJpaVendorAdapter(jpaVendorAdapter);


        local.setDataSource(dataSource());
        Map<String, String> props=new HashMap<>();
        props.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.show-sql","true");
        props.put("hibernate.hbm2ddl.auto","update");
        local.setPackagesToScan("com.multiple.databases.entities1");
        local.setJpaPropertyMap(props);

        return local;

    }

    @Bean("transactionManager")
    @Primary
    public PlatformTransactionManager transactionManager(){

        JpaTransactionManager jpaManager=new JpaTransactionManager();
        jpaManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());


        return jpaManager;


    }





}
