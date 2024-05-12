package com.github.gustavoflor.zarco.config

import com.github.gustavoflor.zarco.core.port.command.CreateStationCommand
import com.github.gustavoflor.zarco.core.port.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.adapter.repository.command.CreateStationCommandImpl
import com.github.gustavoflor.zarco.adapter.repository.query.FindStationByIdQueryImpl
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

@Configuration
class RepositoryConfig(
    @Qualifier("readOnlyNamedParameterJdbcTemplate")
    private val readOnlyNamedParameterJdbcTemplate: NamedParameterJdbcTemplate,
    @Qualifier("readWriteNamedParameterJdbcTemplate")
    private val readWriteNamedParameterJdbcTemplate: NamedParameterJdbcTemplate
) {

    @Bean
    fun createStationCommand(): CreateStationCommand = CreateStationCommandImpl(readWriteNamedParameterJdbcTemplate)

    @Bean
    fun findStationByIdQuery(): FindStationByIdQuery = FindStationByIdQueryImpl(readOnlyNamedParameterJdbcTemplate)

}