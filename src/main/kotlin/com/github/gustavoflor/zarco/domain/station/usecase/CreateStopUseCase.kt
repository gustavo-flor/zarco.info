package com.github.gustavoflor.zarco.domain.station.usecase

import com.github.gustavoflor.zarco.domain.station.Stop

interface CreateStopUseCase {
    fun execute(input: Input): Output

    data class Input(
        val name: String,
        val latitude: Double,
        val longitude: Double
    ) {
        fun stop() = Stop.new(name, latitude, longitude)
    }

    data class Output(
        val stop: Stop
    )
}
