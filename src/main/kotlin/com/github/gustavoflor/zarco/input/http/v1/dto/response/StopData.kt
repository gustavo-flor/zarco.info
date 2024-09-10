package com.github.gustavoflor.zarco.input.http.v1.dto.response

import com.github.gustavoflor.zarco.domain.station.Stop
import java.time.LocalDateTime
import java.util.UUID

data class StopData(
    val id: UUID,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun of(stop: Stop) = StopData(
            id = stop.id,
            name = stop.name,
            latitude = stop.latitude,
            longitude = stop.longitude,
            createdAt = stop.createdAt,
            updatedAt = stop.updatedAt
        )
    }
}
