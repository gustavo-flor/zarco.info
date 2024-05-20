package com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.response

import com.github.gustavoflor.zarco.core.entity.Line
import java.time.LocalDateTime

data class LineResponse(
    val id: Long,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun of(line: Line): LineResponse = LineResponse(
            id = line.id!!,
            name = line.name,
            createdAt = line.createdAt,
            updatedAt = line.updatedAt
        )
    }
}
