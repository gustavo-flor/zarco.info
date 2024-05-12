package com.github.gustavoflor.zarco

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootApplication
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            value = [WorkerApplication::class, JobApplication::class]),
        ComponentScan.Filter(
            type = FilterType.REGEX,
            pattern = ["com.github.gustavoflor.zarco.entrypoint.(worker|job).*"]
        )
    ]
)
class WebApplication

fun main(args: Array<String>) {
    runApplication<WebApplication>(*args)
}
