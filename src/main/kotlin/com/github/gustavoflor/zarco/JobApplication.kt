package com.github.gustavoflor.zarco

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@ComponentScan(
    excludeFilters = [
        ComponentScan.Filter(
            type = FilterType.ASSIGNABLE_TYPE,
            value = [WebApplication::class, WorkerApplication::class]),
        ComponentScan.Filter(
            type = FilterType.REGEX,
            pattern = ["com.github.gustavoflor.zarco.entrypoint.(web|worker).*"]
        )
    ]
)
class JobApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder(JobApplication::class.java)
        .web(WebApplicationType.NONE)
        .run(*args)
}
