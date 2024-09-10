package com.github.gustavoflor.zarco.output.data.command

import com.github.gustavoflor.zarco.domain.station.LineStop
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class CreateLineStopCommand(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SQL = """
            INSERT INTO line_stop (id, line_id, stop_id, parent_id, created_at, updated_at)
            VALUES (:id, :lineId, :stopId, :parentId, :createdAt, :updatedAt)
            """
    }

    fun execute(lineStop: LineStop): LineStop {
        return executeAll(listOf(lineStop)).first()
    }

    fun executeAll(lineStops: List<LineStop>): List<LineStop> {
        val batchParams = lineStops.map { it.params() }.toTypedArray()
        jdbcTemplate.batchUpdate(SQL, batchParams)
        return lineStops
    }

    private fun LineStop.params() = mapOf(
        "id" to id,
        "lineId" to lineId,
        "stopId" to stopId,
        "parentId" to parentId,
        "createdAt" to createdAt,
        "updatedAt" to updatedAt,
    )
}
