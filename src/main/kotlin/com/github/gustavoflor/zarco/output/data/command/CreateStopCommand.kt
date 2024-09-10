package com.github.gustavoflor.zarco.output.data.command

import com.github.gustavoflor.zarco.domain.station.Stop
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class CreateStopCommand(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) {
    companion object {
        private const val SQL = """
            INSERT INTO stop (id, name, latitude, longitude, created_at, updated_at)
            VALUES (:id, :name, :latitude, :longitude, :createdAt, :updatedAt)
            """
    }

    fun execute(stop: Stop): Stop {
        val params = mapOf(
            "id" to stop.id,
            "name" to stop.name,
            "latitude" to stop.latitude,
            "longitude" to stop.longitude,
            "createdAt" to stop.createdAt,
            "updatedAt" to stop.updatedAt
        )
        jdbcTemplate.update(SQL, params)
        return stop
    }
}
