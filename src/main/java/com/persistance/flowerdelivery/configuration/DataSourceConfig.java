package com.persistance.flowerdelivery.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix="com.persistance.flowerdelivery")
    public DataSource getDatSource(DataSourceProperties dataSourceProperties) {
        DataSourceBuilder<?> dsb = DataSourceBuilder.create();
        dsb.url("jdbc:mysql://localhost:3306/plant");
        dsb.username("root");
        dsb.password(securePasswordService());
        return dsb.build();
    }

    private String securePasswordService() {
        return "";
    }
}
