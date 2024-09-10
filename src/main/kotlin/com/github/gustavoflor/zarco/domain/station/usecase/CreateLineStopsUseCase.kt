package com.github.gustavoflor.zarco.domain.station.usecase

import com.github.gustavoflor.zarco.domain.station.LineStop
import java.util.UUID

interface CreateLineStopsUseCase {
    fun execute(input: Input): Output

    data class Input(
        val parentId: UUID?,
        val lineId: UUID,
        val stopIds: List<UUID>
    ) {
        fun lineStops(): List<LineStop> {
            var previousId = parentId
            return stopIds.map { stopId -> LineStop.new(lineId, stopId, previousId).also { previousId = it.id } }
        }
    }

    data class Output(
        val lineStops: List<LineStop> = emptyList()
    )
}
