package com.github.gustavoflor.zarco.core.model

import java.time.LocalDateTime

data class Line(
    val id: Long? = null,
    val name: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = createdAt
)
