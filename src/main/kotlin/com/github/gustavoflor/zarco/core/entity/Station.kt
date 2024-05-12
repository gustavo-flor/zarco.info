package com.github.gustavoflor.zarco.core.entity

import java.time.LocalDateTime

data class Station(
    val id: Long? = null,
    val name: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)
