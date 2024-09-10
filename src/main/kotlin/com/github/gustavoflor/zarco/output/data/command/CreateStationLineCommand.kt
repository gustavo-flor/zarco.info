package com.github.gustavoflor.zarco.output.data.command

import com.github.gustavoflor.zarco.domain.station.StationLine
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class CreateStationLineCommand(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SQL = """
            INSERT INTO station_line (station_id, line_id, created_at)
            VALUES (:stationId, :lineId, :createdAt)
            """
    }

    fun execute(stationLine: StationLine): StationLine {
        return executeAll(listOf(stationLine)).first()
    }

    fun executeAll(stationLines: List<StationLine>): List<StationLine> {
        val batchParams = stationLines.map { it.params() }.toTypedArray()
        jdbcTemplate.batchUpdate(SQL, batchParams)
        return stationLines
    }

    private fun StationLine.params() = mapOf(
        "stationId" to stationId,
        "lineId" to lineId,
        "createdAt" to createdAt
    )
}
