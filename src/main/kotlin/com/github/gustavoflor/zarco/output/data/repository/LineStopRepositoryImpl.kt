package com.github.gustavoflor.zarco.output.data.repository

import com.github.gustavoflor.zarco.domain.station.LineStop
import com.github.gustavoflor.zarco.domain.station.repository.LineStopRepository
import com.github.gustavoflor.zarco.output.data.command.CreateLineStopCommand
import com.github.gustavoflor.zarco.output.data.command.UpdateLineStopCommand
import com.github.gustavoflor.zarco.output.data.query.FindLastLineStopByLineIdQuery
import com.github.gustavoflor.zarco.output.data.query.FindLineStopByLineIdAndParentIdQuery
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.util.UUID

@Repository
class LineStopRepositoryImpl(
    private val createLineStopCommand: CreateLineStopCommand,
    private val updateLineStopCommand: UpdateLineStopCommand,
    private val findLineStopByLineIdAndParentIdQuery: FindLineStopByLineIdAndParentIdQuery,
    private val findLastLineStopByLineIdQuery: FindLastLineStopByLineIdQuery
) : LineStopRepository {
    override fun save(lineStop: LineStop): LineStop = createLineStopCommand.execute(lineStop)

    override fun saveAll(lineStops: List<LineStop>): List<LineStop> = createLineStopCommand.executeAll(lineStops)

    override fun update(lineStop: LineStop): LineStop {
        return lineStop.copy(updatedAt = LocalDateTime.now()).let { updateLineStopCommand.execute(it) }
    }

    override fun findLastByLineId(lineId: UUID): LineStop? = findLastLineStopByLineIdQuery.execute(lineId)

    override fun deleteById(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun findById(id: UUID): LineStop? {
        TODO("Not yet implemented")
    }

    override fun findByLineIdAndParentId(lineId: UUID, parentId: UUID?): LineStop? = findLineStopByLineIdAndParentIdQuery.execute(lineId, parentId)
}
