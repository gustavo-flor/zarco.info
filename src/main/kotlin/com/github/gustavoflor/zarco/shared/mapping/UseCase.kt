package com.github.gustavoflor.zarco.shared.mapping

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Component
annotation class UseCase(
    @get:AliasFor(annotation = Component::class)
    val value: String = ""
)
