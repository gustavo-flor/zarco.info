package com.github.gustavoflor.zarco.output.data.command

import com.github.gustavoflor.zarco.domain.station.Station
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class CreateStationCommand(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SQL = """
            INSERT INTO station (id, name, external_id, created_at, updated_at)
            VALUES (:id, :name, :externalId, :createdAt, :updatedAt)
            """
    }

    fun execute(station: Station): Station {
        val params = mapOf(
            "id" to station.id,
            "name" to station.name,
            "externalId" to station.externalId,
            "createdAt" to station.createdAt,
            "updatedAt" to station.updatedAt
        )
        jdbcTemplate.update(SQL, params)
        return station
    }
}
