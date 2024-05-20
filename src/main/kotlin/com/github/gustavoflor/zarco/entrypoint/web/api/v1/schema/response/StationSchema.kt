package com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response

import com.github.gustavoflor.zarco.core.model.Station
import java.time.LocalDateTime

data class StationSchema(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun of(station: Station): StationSchema = StationSchema(
            id = station.id!!,
            name = station.name,
            createdAt = station.createdAt,
            updatedAt = station.updatedAt
        )
    }
}
