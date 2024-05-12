package com.github.gustavoflor.zarco.repository.mapper

import com.github.gustavoflor.zarco.core.entity.Station
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet
import java.time.LocalDateTime
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField

class StationMapper : RowMapper<Station> {

    companion object {
        private val dateTimeFormatter = DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .parseLenient()
            .appendPattern("yyyy-MM-dd HH:mm:ss")
            .appendFraction(ChronoField.MILLI_OF_SECOND, 3, 6, true)
            .toFormatter()
    }

    override fun mapRow(rs: ResultSet, rowNum: Int): Station? = Station(
        id = rs.getLong("id"),
        name = rs.getString("name"),
        createdAt = rs.getString("created_at").let { LocalDateTime.parse(it, dateTimeFormatter) },
        updatedAt = rs.getString("updated_at").let { LocalDateTime.parse(it, dateTimeFormatter) }
    )

}