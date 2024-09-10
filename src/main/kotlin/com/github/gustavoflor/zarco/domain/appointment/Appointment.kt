package com.github.gustavoflor.zarco.domain.appointment

import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

data class Appointment(
    val id: UUID,
    val lineId: UUID,
    val name: String,
    val type: AppointmentType,
    val departureTime: LocalTime,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun new(lineId: UUID, name: String, type: AppointmentType, departureTime: LocalTime) = Appointment(
            id = UUID.randomUUID(),
            lineId = lineId,
            name = name,
            type = type,
            departureTime = departureTime,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now()
        )
    }
}
