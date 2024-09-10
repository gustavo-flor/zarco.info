package com.github.gustavoflor.zarco.output.data.query

import com.github.gustavoflor.zarco.domain.station.Station
import com.github.gustavoflor.zarco.output.data.query.mapper.StationMapper
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class FindStationByExternalIdQuery(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
    private val stationMapper: StationMapper
) {
    companion object {
        private const val SQL = """
            SELECT *
            FROM station
            WHERE external_id = :externalId
            """
    }

    fun execute(externalId: String): Station? {
        val params = mapOf("externalId" to externalId)
        return try {
            jdbcTemplate.queryForObject(SQL, params, stationMapper)
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }
}
