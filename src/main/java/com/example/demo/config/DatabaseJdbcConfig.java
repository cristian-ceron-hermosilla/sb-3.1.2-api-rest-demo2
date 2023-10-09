package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@ConditionalOnProperty(name = "app.features.jdbc.enabled", havingValue = "true", matchIfMissing = false)
public class DatabaseJdbcConfig {

   @Primary
   @Bean(name = "mainDataSource")
   public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
      return new NamedParameterJdbcTemplate(dataSource);
	  }
}

