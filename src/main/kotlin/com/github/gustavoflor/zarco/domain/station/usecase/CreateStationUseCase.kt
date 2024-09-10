package com.github.gustavoflor.zarco.domain.station.usecase

import com.github.gustavoflor.zarco.domain.station.Station

interface CreateStationUseCase {
    fun execute(input: Input): Output

    data class Input(
        val name: String,
        val externalId: String
    ) {
        fun station() = Station.new(
            name = name,
            externalId = externalId
        )
    }

    data class Output(
        val station: Station
    )
}
