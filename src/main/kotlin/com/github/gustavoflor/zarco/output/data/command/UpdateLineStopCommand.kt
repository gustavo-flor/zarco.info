package com.github.gustavoflor.zarco.output.data.command

import com.github.gustavoflor.zarco.domain.station.LineStop
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class UpdateLineStopCommand(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SQL = """
            UPDATE line_stop
            SET 
                parent_id = :parentId, 
                updated_at = :updatedAt
            WHERE id = :id
            """
    }

    fun execute(lineStop: LineStop): LineStop {
        val params = mapOf(
            "id" to lineStop.id,
            "parentId" to lineStop.parentId,
            "updatedAt" to lineStop.updatedAt
        )
        jdbcTemplate.update(SQL, params)
        return lineStop
    }
}
