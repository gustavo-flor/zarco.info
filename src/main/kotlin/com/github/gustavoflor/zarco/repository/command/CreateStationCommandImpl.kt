package com.github.gustavoflor.zarco.repository.command

import com.github.gustavoflor.zarco.core.entity.Station
import com.github.gustavoflor.zarco.core.port.CreateStationCommand
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder

class CreateStationCommandImpl(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : CreateStationCommand {

    companion object {
        private const val SQL = "INSERT INTO station (name, created_at, updated_at) VALUES (:name, :created_at, :updated_at)"
    }

    override fun execute(station: Station): Station {
        val params = mapOf(
            "name" to station.name,
            "created_at" to station.createdAt,
            "updated_at" to station.updatedAt
        )
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(SQL, MapSqlParameterSource(params), keyHolder, arrayOf("id"))
        return Station(
            id = keyHolder.key!!.toLong(),
            name = station.name,
            createdAt = station.createdAt,
            updatedAt = station.updatedAt
        )
    }

}