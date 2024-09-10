package com.github.gustavoflor.zarco.input.http.v1.dto.response

import com.github.gustavoflor.zarco.domain.station.Line
import java.time.LocalDateTime
import java.util.UUID

data class LineData(
    val id: UUID,
    val name: String,
    val externalId: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun of(line: Line) = LineData(
            id = line.id,
            name = line.name,
            externalId = line.externalId,
            createdAt = line.createdAt,
            updatedAt = line.updatedAt
        )
    }
}
