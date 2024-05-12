package com.github.gustavoflor.zarco.repository.query

import com.github.gustavoflor.zarco.core.entity.Station
import com.github.gustavoflor.zarco.core.port.FindStationByIdQuery
import com.github.gustavoflor.zarco.repository.mapper.StationMapper
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
        } catch (ex: EmptyResultDataAccessException) {
            null
        }
    }

}