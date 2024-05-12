package com.github.gustavoflor.zarco.adapter.queue

import com.github.gustavoflor.zarco.core.event.NewStationEvent
import com.github.gustavoflor.zarco.core.event.publisher.NewStationEventPublisher
import io.awspring.cloud.sqs.operations.SqsTemplate

class NewStationEventPublisherSqs(
    private val sqsTemplate: SqsTemplate,
    private val queueUrl: String
) : NewStationEventPublisher {
    override fun execute(event: NewStationEvent) {
        sqsTemplate.send(queueUrl, event)
    }
}