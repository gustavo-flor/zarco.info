package com.github.gustavoflor.zarco.domain.station

import java.time.LocalDateTime
import java.util.UUID

data class LineStop(
    val id: UUID,
    val lineId: UUID,
    val stopId: UUID,
    val parentId: UUID?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun new(lineId: UUID, stopId: UUID, parentId: UUID?) = LineStop(
            id = UUID.randomUUID(),
            lineId = lineId,
            stopId = stopId,
            parentId = parentId,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}
