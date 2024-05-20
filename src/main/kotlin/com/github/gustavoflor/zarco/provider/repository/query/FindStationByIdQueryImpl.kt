package com.github.gustavoflor.zarco.provider.repository.query

import com.github.gustavoflor.zarco.core.model.Station
import com.github.gustavoflor.zarco.core.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.provider.repository.StationMapper
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class FindStationByIdQueryImpl(
    @Qualifier("readOnlyNamedParameterJdbcTemplate")
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
