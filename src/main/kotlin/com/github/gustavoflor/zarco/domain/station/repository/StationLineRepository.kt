package com.github.gustavoflor.zarco.domain.station.repository

import com.github.gustavoflor.zarco.domain.station.StationLine

interface StationLineRepository {
    fun save(stationLine: StationLine): StationLine

    fun saveAll(stationLines: List<StationLine>): List<StationLine>
}
