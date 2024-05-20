package com.github.gustavoflor.zarco.adapter.repository.query

import com.github.gustavoflor.zarco.adapter.repository.mapper.LineMapper
import com.github.gustavoflor.zarco.core.entity.Line
import com.github.gustavoflor.zarco.core.port.query.FindLinesByStationIdQuery
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class FindLinesByStationIdQueryImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : FindLinesByStationIdQuery {
    companion object {
        private const val SQL = """
            SELECT line.* 
            FROM line 
            JOIN station_line ON line.id = station_line.line_id 
            WHERE station_line.station_id = :stationId
            """
    }

    override fun execute(stationId: Long): List<Line> {
        val params = mapOf("stationId" to stationId)
        return jdbcTemplate.query(SQL, MapSqlParameterSource(params), LineMapper())
    }
}
