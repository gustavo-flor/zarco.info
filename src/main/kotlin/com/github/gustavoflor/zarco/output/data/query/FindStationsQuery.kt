package com.github.gustavoflor.zarco.output.data.query

import com.github.gustavoflor.zarco.domain.station.Station
import com.github.gustavoflor.zarco.output.data.query.mapper.StationMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class FindStationsQuery(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
    private val stationMapper: StationMapper
) {
    companion object {
        private const val SQL = "SELECT * FROM station"
    }

    fun execute(): List<Station> {
        val params = mapOf<String, Any?>()
        return jdbcTemplate.query(SQL, params, stationMapper)
    }
}
