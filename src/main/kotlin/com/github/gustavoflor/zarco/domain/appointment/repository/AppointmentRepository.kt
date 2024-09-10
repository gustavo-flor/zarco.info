package com.github.gustavoflor.zarco.domain.appointment.repository

import com.github.gustavoflor.zarco.domain.appointment.Appointment

interface AppointmentRepository {
    fun save(appointment: Appointment): Appointment
}
