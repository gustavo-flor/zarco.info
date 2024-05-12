package com.github.gustavoflor.zarco.core.event.publisher

import com.github.gustavoflor.zarco.core.event.NewStationEvent

fun interface NewStationEventPublisher {
    fun execute(event: NewStationEvent)
}