package com.github.gustavoflor.zarco.config

import com.github.gustavoflor.zarco.adapter.repository.command.CreateLineCommandImpl
import com.github.gustavoflor.zarco.core.port.command.CreateStationCommand
import com.github.gustavoflor.zarco.core.port.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.adapter.repository.command.CreateStationCommandImpl
import com.github.gustavoflor.zarco.adapter.repository.command.CreateStationLineCommandImpl
import com.github.gustavoflor.zarco.adapter.repository.command.DeleteStationLineCommandImpl
import com.github.gustavoflor.zarco.adapter.repository.query.FindStationByIdQueryImpl
import com.github.gustavoflor.zarco.core.port.command.CreateLineCommand
import com.github.gustavoflor.zarco.core.port.command.CreateStationLineCommand
import com.github.gustavoflor.zarco.core.port.command.DeleteStationLineCommand
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

    @Bean
    fun createLineCommand(): CreateLineCommand = CreateLineCommandImpl(readWriteNamedParameterJdbcTemplate)

    @Bean
    fun deleteStationLineCommand(): DeleteStationLineCommand = DeleteStationLineCommandImpl(readWriteNamedParameterJdbcTemplate)

    @Bean
    fun createStationLineCommand(): CreateStationLineCommand = CreateStationLineCommandImpl(readWriteNamedParameterJdbcTemplate)
}
