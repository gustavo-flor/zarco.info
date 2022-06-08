package com.github.gustavoflor.zarco.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.sql.DataSource;

@Configuration
public class TestContainersConfig {
    private static final String DB_NAME = "zarco";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String PORT = "5432";

    @Bean(initMethod = "start")
    PostgreSQLContainer<?> databaseContainer() {
        return new PostgreSQLContainer("postgres:14-alpine")
                .withUsername(USERNAME)
                .withPassword(PASSWORD)
                .withDatabaseName(DB_NAME);
    }

    @Bean
    @Primary
    DataSource dataSource(JdbcDatabaseContainer container) {
        int port = container.getMappedPort(Integer.parseInt(PORT));
        String host = container.getHost();
        String databaseName = container.getDatabaseName();
        return DataSourceBuilder.create()
                .url(String.format("jdbc:postgresql://%s:%s/%s", host, port, databaseName))
                .username(container.getUsername())
                .password(container.getPassword())
                .driverClassName(container.getDriverClassName())
                .build();
    }
}
