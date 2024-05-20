package com.github.gustavoflor.zarco.provider.repository

import com.github.gustavoflor.zarco.core.model.Line
import com.github.gustavoflor.zarco.util.DateTimeUtil.DATE_TIME_ISO_8601_FORMATTER
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.time.LocalDateTime

class LineMapper : RowMapper<Line> {
    override fun mapRow(rs: ResultSet, rowNum: Int) = Line(
        id = rs.getLong("id"),
        name = rs.getString("name"),
        createdAt = rs.getString("created_at").let { LocalDateTime.parse(it, DATE_TIME_ISO_8601_FORMATTER) },
        updatedAt = rs.getString("updated_at").let { LocalDateTime.parse(it, DATE_TIME_ISO_8601_FORMATTER) }
    )
}