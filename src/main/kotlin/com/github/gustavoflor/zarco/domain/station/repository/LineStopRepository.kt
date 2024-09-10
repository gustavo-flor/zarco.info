package com.github.gustavoflor.zarco.domain.station.repository

import com.github.gustavoflor.zarco.domain.station.LineStop
import java.util.UUID

interface LineStopRepository {
    fun save(lineStop: LineStop): LineStop

    fun saveAll(lineStops: List<LineStop>): List<LineStop>

    fun update(lineStop: LineStop): LineStop

    fun findByLineIdAndParentId(lineId: UUID, parentId: UUID?): LineStop?

    fun findLastByLineId(lineId: UUID): LineStop?

    fun deleteById(id: UUID)

    fun findById(id: UUID): LineStop?
}
