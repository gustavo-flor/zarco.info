package com.github.gustavoflor.zarco.core.model

import java.time.LocalDateTime

data class Stop(
    val id: Long? = null,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val stationId: Long? = null,
    val createdAt: LocalDateTime? = LocalDateTime.now(),
    val updatedAt: LocalDateTime? = createdAt
)
