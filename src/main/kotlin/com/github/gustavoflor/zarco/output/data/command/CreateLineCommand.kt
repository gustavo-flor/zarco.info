package com.github.gustavoflor.zarco.output.data.command

import com.github.gustavoflor.zarco.domain.station.Line
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class CreateLineCommand(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SQL = """
            INSERT INTO line (id, name, external_id, created_at, updated_at)
            VALUES (:id, :name, :externalId, :createdAt, :updatedAt)
            """
    }

    fun execute(line: Line): Line {
        val params = line.params()
        jdbcTemplate.update(SQL, params)
        return line
    }

    private fun Line.params() = mapOf(
        "id" to id,
        "name" to name,
        "externalId" to externalId,
        "createdAt" to createdAt,
        "updatedAt" to updatedAt
    )
}
