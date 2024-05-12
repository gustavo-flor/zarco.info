package com.github.gustavoflor.zarco.config

import com.github.gustavoflor.zarco.core.event.publisher.NewStationEventPublisher
import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SqsConfig(
    private val properties: SqsConfigProperties,
    private val sqsTemplate: SqsTemplate
) {

    @Bean
    fun newStationEventPublisher() = NewStationEventPublisher { sqsTemplate.send(properties.newStationQueueUrl, it) }

}