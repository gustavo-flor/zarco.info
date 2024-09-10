package com.github.gustavoflor.zarco.output.data.query

import com.github.gustavoflor.zarco.domain.station.LineStop
import com.github.gustavoflor.zarco.output.data.query.mapper.LineStopMapper
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class FindLineStopByLineIdAndParentIdQuery(
    private val jdbcTemplate: NamedParameterJdbcTemplate,
    private val lineStopMapper: LineStopMapper
) {
    companion object {
        private const val SQL = """
            SELECT * 
            FROM line_stop
            WHERE line_id = :lineId 
            AND ((:parentId::UUID IS NULL AND parent_id IS NULL) OR parent_id = :parentId)
            """
    }

    fun execute(lineId: UUID, parentId: UUID?): LineStop? {
        val params = mapOf(
            "lineId" to lineId,
            "parentId" to parentId
        )
        return try {
            jdbcTemplate.queryForObject(SQL, params, lineStopMapper)
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }
}
