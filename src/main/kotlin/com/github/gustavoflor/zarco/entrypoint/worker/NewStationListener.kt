package com.github.gustavoflor.zarco.entrypoint.worker

import com.github.gustavoflor.zarco.core.event.NewStationEvent
import io.awspring.cloud.sqs.annotation.SqsListener
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class NewStationListener {

    private val log = LoggerFactory.getLogger(javaClass)

    @SqsListener(value = ["zarco-new-station"])
    fun accept(@Payload event: NewStationEvent) {
        log.info("New station received: ${event.station.name} [${event.occurredAt}]")
    }

}