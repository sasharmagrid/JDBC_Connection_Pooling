package org.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceFactory {
    public static HikariDataSource create() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/testdb");
        config.setUsername("user");
        config.setPassword("password");
        config.setMaximumPoolSize(5);
        config.setIdleTimeout(60000);
        config.setConnectionTimeout(30000);
        return new HikariDataSource(config);
    }
}
