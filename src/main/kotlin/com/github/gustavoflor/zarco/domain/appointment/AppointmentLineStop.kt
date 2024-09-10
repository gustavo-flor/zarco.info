package com.github.gustavoflor.zarco.domain.appointment

import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

data class AppointmentLineStop(
    val id: UUID,
    val appointmentId: UUID,
    val lineStopId: UUID,
    val arrivalTime: LocalTime,
    val departureTime: LocalTime,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
