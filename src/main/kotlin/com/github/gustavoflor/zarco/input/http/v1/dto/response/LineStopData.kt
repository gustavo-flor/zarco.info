package com.github.gustavoflor.zarco.input.http.v1.dto.response

import com.github.gustavoflor.zarco.domain.station.LineStop
import java.time.LocalDateTime
import java.util.UUID

data class LineStopData(
    val id: UUID,
    val lineId: UUID,
    val stopId: UUID,
    val parentId: UUID?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun of(lineStop: LineStop) = LineStopData(
            id = lineStop.id,
            lineId = lineStop.lineId,
            stopId = lineStop.stopId,
            parentId = lineStop.parentId,
            createdAt = lineStop.createdAt,
            updatedAt = lineStop.updatedAt
        )
    }
}
