package com.github.gustavoflor.zarco.adapter.repository.command

import com.github.gustavoflor.zarco.core.port.command.DeleteStationLineCommand
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate

class DeleteStationLineCommandImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : DeleteStationLineCommand {
    companion object {
        private const val SQL = "DELETE FROM station_line WHERE station_id = :stationId AND line_id = :lineId"
    }

    override fun execute(stationId: Long, lineId: Long) {
        val params = mapOf(
            "stationId" to stationId,
            "lineId" to lineId
        )
        jdbcTemplate.update(SQL, MapSqlParameterSource(params))
    }
}
