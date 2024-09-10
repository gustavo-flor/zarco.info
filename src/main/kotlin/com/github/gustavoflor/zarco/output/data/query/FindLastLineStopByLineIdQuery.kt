package com.github.gustavoflor.zarco.output.data.query

import com.github.gustavoflor.zarco.domain.station.LineStop
import com.github.gustavoflor.zarco.output.data.query.mapper.LineStopMapper
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FindLastLineStopByLineIdQuery(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
    private val lineStopMapper: LineStopMapper
) {
    companion object {
        private const val SQL = """
            SELECT ls.*
            FROM line_stop ls
            WHERE ls.line_id = :lineId
            AND ls.id NOT IN (SELECT parent_id FROM line_stop WHERE parent_id IS NOT NULL)
            """
    }

    fun execute(lineId: UUID): LineStop? {
        val params = mapOf("lineId" to lineId)
        return try {
            jdbcTemplate.queryForObject(SQL, params, lineStopMapper)
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }
}
