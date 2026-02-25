package com.example.E_Commerce_System_Backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();

        source.setUrl("jdbc:postgresql://localhost:5432/e_commerce_system");
        source.setUsername("postgres");
        source.setPassword("1234");

        return source;
    }
}
