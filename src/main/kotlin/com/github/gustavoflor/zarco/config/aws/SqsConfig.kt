package com.github.gustavoflor.zarco.config.aws

import com.github.gustavoflor.zarco.adapter.queue.NewStationEventPublisherSqs
import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SqsConfig(
    private val properties: SqsConfigProperties,
    private val sqsTemplate: SqsTemplate
) {

    @Bean
    fun newStationEventPublisher() = NewStationEventPublisherSqs(sqsTemplate, properties.newStationQueueUrl)

}