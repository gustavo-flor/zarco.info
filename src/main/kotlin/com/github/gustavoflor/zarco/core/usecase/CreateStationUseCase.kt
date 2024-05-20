package com.github.gustavoflor.zarco.core.usecase

import com.github.gustavoflor.zarco.core.entity.Station

interface CreateStationUseCase {
    fun execute(input: Input): Output

    data class Input(val stationName: String)

    data class Output(val station: Station)
}
