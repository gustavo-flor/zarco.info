package com.github.gustavoflor.zarco.domain.station

import java.time.LocalDateTime
import java.util.UUID

data class Stop(
    val id: UUID,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun new(name: String, latitude: Double, longitude: Double) = Stop(
            id = UUID.randomUUID(),
            name = name,
            latitude = latitude,
            longitude = longitude,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}
