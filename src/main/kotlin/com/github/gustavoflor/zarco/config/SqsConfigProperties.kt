package com.github.gustavoflor.zarco.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("aws.sqs")
class SqsConfigProperties {

    lateinit var newStationQueueUrl: String

}