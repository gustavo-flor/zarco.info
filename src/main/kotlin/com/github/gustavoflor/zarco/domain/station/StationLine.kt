package com.github.gustavoflor.zarco.domain.station

import java.time.LocalDateTime
import java.util.UUID

data class StationLine(
    val stationId: UUID,
    val lineId: UUID,
    val createdAt: LocalDateTime
) {
    companion object {
        fun new(stationId: UUID, lineId: UUID) = StationLine(
            stationId = stationId,
            lineId = lineId,
            createdAt = LocalDateTime.now()
        )
    }
}
