package com.github.gustavoflor.zarco.domain.station.usecase

import com.github.gustavoflor.zarco.domain.station.Line
import com.github.gustavoflor.zarco.domain.station.StationLine
import java.util.UUID

interface CreateLineUseCase {
    fun execute(input: Input): Output

    data class Input(
        val name: String,
        val externalId: String,
        val stationIds: List<UUID>
    ) {
        fun line() = Line.new(
            name = name,
            externalId = externalId
        )
    }

    data class Output(
        val line: Line,
        val stationLines: List<StationLine>
    )
}
