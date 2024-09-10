package com.github.gustavoflor.zarco.output.data.query.mapper

import com.github.gustavoflor.zarco.domain.station.Line
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.UUID

@Component
class LineMapper : RowMapper<Line> {
    override fun mapRow(rs: ResultSet, rowNum: Int) = Line(
        id = rs.getString("id").let { UUID.fromString(it) },
        name = rs.getString("name"),
        externalId = rs.getString("external_id"),
        createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
        updatedAt = rs.getTimestamp("updated_at").toLocalDateTime()
    )
}
