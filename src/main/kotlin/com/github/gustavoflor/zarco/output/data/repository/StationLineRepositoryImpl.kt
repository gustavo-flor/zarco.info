package com.github.gustavoflor.zarco.output.data.repository

import com.github.gustavoflor.zarco.domain.station.StationLine
import com.github.gustavoflor.zarco.domain.station.repository.StationLineRepository
import com.github.gustavoflor.zarco.output.data.command.CreateStationLineCommand
import org.springframework.stereotype.Repository

@Repository
class StationLineRepositoryImpl(
    private val createStationLineCommand: CreateStationLineCommand
) : StationLineRepository {
    override fun save(stationLine: StationLine): StationLine = createStationLineCommand.execute(stationLine)

    override fun saveAll(stationLines: List<StationLine>): List<StationLine> {
        if (stationLines.isEmpty()) {
            return emptyList()
        }
        return createStationLineCommand.executeAll(stationLines)
    }
}
