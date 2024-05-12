package com.github.gustavoflor.zarco.core.event

import com.github.gustavoflor.zarco.core.entity.Station
import java.time.LocalDateTime

data class NewStationEvent(
    val station: Station,
    val occurredAt: LocalDateTime = LocalDateTime.now()
)
