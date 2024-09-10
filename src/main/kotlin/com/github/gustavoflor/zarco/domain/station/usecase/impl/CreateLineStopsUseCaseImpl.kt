package com.github.gustavoflor.zarco.domain.station.usecase.impl

import com.github.gustavoflor.zarco.domain.station.LineStop
import com.github.gustavoflor.zarco.domain.station.repository.LineStopRepository
import com.github.gustavoflor.zarco.domain.station.usecase.CreateLineStopsUseCase
import com.github.gustavoflor.zarco.shared.mapping.UseCase
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@UseCase
class CreateLineStopsUseCaseImpl(
    private val lineStopRepository: LineStopRepository
) : CreateLineStopsUseCase {
    @Transactional
    override fun execute(input: CreateLineStopsUseCase.Input): CreateLineStopsUseCase.Output {
        if (input.stopIds.isEmpty()) {
            return CreateLineStopsUseCase.Output()
        }
        val nextLineStop = findLineStopByParentId(input.lineId, input.parentId)
            ?.let { updateParentId(it, findLastLineStop(input.lineId)!!.id) }
        val lineStops = lineStopRepository.saveAll(input.lineStops())
        updateParentId(nextLineStop, lineStops.last().id)
        return CreateLineStopsUseCase.Output(lineStops)
    }

    private fun findLastLineStop(lineId: UUID) = lineStopRepository.findLastByLineId(lineId)

    private fun findLineStopByParentId(lineId: UUID, parentId: UUID?) = lineStopRepository.findByLineIdAndParentId(lineId, parentId)

    private fun updateParentId(lineStop: LineStop?, parentId: UUID) = lineStop
        ?.copy(parentId = parentId)
        ?.let { lineStopRepository.update(it) }
}
