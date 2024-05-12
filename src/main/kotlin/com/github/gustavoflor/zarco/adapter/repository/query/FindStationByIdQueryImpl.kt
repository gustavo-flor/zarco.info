package com.github.gustavoflor.zarco.adapter.repository.query

import com.github.gustavoflor.zarco.core.entity.Station
import com.github.gustavoflor.zarco.core.port.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.adapter.repository.mapper.StationMapper
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class FindStationByIdQueryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : FindStationByIdQuery {

    companion object {
        private const val SQL = "SELECT * FROM station WHERE id = :id"
    }

    override fun execute(id: Long): Station? {
        val params = mapOf("id" to id)
        return try {
            jdbcTemplate.queryForObject(SQL, params, StationMapper())
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

}