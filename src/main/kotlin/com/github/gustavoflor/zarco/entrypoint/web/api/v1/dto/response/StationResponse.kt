package com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.response

import com.github.gustavoflor.zarco.core.entity.Station
import java.time.LocalDateTime

data class StationResponse(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {

    companion object {
        fun of(station: Station): StationResponse = StationResponse(
            id = station.id!!,
            name = station.name,
            createdAt = station.createdAt,
            updatedAt = station.updatedAt
        )
    }

}
