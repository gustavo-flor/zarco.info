package com.github.gustavoflor.zarco.provider.repository.command

import com.github.gustavoflor.zarco.core.command.CreateStationLineCommand
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class CreateStationLineCommandImpl(
    @Qualifier("readWriteNamedParameterJdbcTemplate")
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : CreateStationLineCommand {
    companion object {
        private const val SQL = """
            INSERT INTO station_line 
                (station_id, line_id, created_at)
            VALUES
                (:stationId, :lineId, :createdAt)
            """
    }

    override fun execute(stationId: Long, lineId: Long) {
        val params = mapOf(
            "stationId" to stationId,
            "lineId" to lineId,
            "createdAt" to LocalDateTime.now()
        )
        jdbcTemplate.update(SQL, MapSqlParameterSource(params))
    }
}
