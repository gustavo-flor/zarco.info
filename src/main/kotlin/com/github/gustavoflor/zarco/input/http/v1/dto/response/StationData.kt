package com.github.gustavoflor.zarco.input.http.v1.dto.response

import com.github.gustavoflor.zarco.domain.station.Station
import java.time.LocalDateTime
import java.util.UUID

data class StationData(
    val id: UUID,
    val name: String,
    val externalId: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun of(station: Station) = StationData(
            id = station.id,
            name = station.name,
            externalId = station.externalId,
            createdAt = station.createdAt,
            updatedAt = station.updatedAt
        )
    }
}
