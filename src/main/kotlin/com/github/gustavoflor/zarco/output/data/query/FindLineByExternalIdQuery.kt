package com.github.gustavoflor.zarco.output.data.query

import com.github.gustavoflor.zarco.domain.station.Line
import com.github.gustavoflor.zarco.output.data.query.mapper.LineMapper
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class FindLineByExternalIdQuery(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
    private val lineMapper: LineMapper
) {
    companion object {
        private const val SQL = """
            SELECT *
            FROM line
            WHERE external_id = :externalId
            """
    }

    fun execute(externalId: String): Line? {
        val params = mapOf("externalId" to externalId)
        return try {
            jdbcTemplate.queryForObject(SQL, params, lineMapper)
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }
}
