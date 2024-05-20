package com.github.gustavoflor.zarco.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
class DataSourceConfig {
    @Bean
    @ConfigurationProperties("datasource.read-write")
    fun readWriteDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("datasource.read-write.hikari")
    fun readWriteDataSource(@Qualifier("readWriteDataSourceProperties") dataSourceProperties: DataSourceProperties): HikariDataSource {
        return dataSourceProperties
            .initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun readWriteJdbcTemplate(@Qualifier("readWriteDataSource") dataSource: DataSource): JdbcTemplate {
        return JdbcTemplate(dataSource)
    }

    @Bean
    fun readWriteNamedParameterJdbcTemplate(@Qualifier("readWriteDataSource") dataSource: DataSource): NamedParameterJdbcTemplate {
        return NamedParameterJdbcTemplate(dataSource)
    }

    @Bean
    @ConfigurationProperties("datasource.read-only")
    fun readOnlyDataSourceProperties(): DataSourceProperties {
        return DataSourceProperties()
    }

    @Bean
    @ConfigurationProperties("datasource.read-only.hikari")
    fun readOnlyDataSource(@Qualifier("readOnlyDataSourceProperties") dataSourceProperties: DataSourceProperties): HikariDataSource {
        return dataSourceProperties
            .initializeDataSourceBuilder()
            .type(HikariDataSource::class.java)
            .build()
    }

    @Bean
    fun readOnlyJdbcTemplate(@Qualifier("readOnlyDataSource") dataSource: HikariDataSource): JdbcTemplate {
        require(dataSource.isReadOnly)
        return JdbcTemplate(dataSource)
    }

    @Bean
    fun readOnlyNamedParameterJdbcTemplate(@Qualifier("readOnlyDataSource") dataSource: HikariDataSource): NamedParameterJdbcTemplate {
        require(dataSource.isReadOnly)
        return NamedParameterJdbcTemplate(dataSource)
    }

    @Bean
    fun transactionManager(@Qualifier("readWriteDataSource") dataSource: HikariDataSource): TransactionManager = DataSourceTransactionManager(dataSource)
}
