package com.github.gustavoflor.zarco.config

import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
class DataSourceTestConfig {

    @Bean
    @Primary
    fun dataSource(@Qualifier("readWriteDataSource") dataSource: HikariDataSource) = dataSource

}