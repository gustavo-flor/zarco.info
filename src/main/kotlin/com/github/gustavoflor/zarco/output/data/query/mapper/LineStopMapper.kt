package com.github.gustavoflor.zarco.output.data.query.mapper

import com.github.gustavoflor.zarco.domain.station.LineStop
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component
import java.sql.ResultSet
import java.util.UUID

@Component
class LineStopMapper : RowMapper<LineStop> {
    override fun mapRow(rs: ResultSet, rowNum: Int) = LineStop(
        id = rs.getString("id").let { UUID.fromString(it) },
        lineId = rs.getString("line_id").let { UUID.fromString(it) },
        stopId = rs.getString("stop_id").let { UUID.fromString(it) },
        parentId = rs.getString("parent_id")?.let { UUID.fromString(it) },
        createdAt = rs.getTimestamp("created_at").toLocalDateTime(),
        updatedAt = rs.getTimestamp("updated_at").toLocalDateTime()
    )
}
