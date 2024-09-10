package com.github.gustavoflor.zarco.domain.station

import java.time.LocalDateTime
import java.util.UUID

data class Station(
    val id: UUID,
    val name: String,
    val externalId: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun new(name: String, externalId: String) = Station(
            id = UUID.randomUUID(),
            name = name,
            externalId = externalId,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}
