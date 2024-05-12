package com.github.gustavoflor.zarco

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootApplication
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            value = [WebApplication::class, JobApplication::class]),
        ComponentScan.Filter(
            type = FilterType.REGEX,
            pattern = ["com.github.gustavoflor.zarco.entrypoint.(web|job).*"]
        )
    ]
)
class WorkerApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(WorkerApplication::class.java)
        .web(WebApplicationType.NONE)
        .run(*args)
}
