package com.github.gustavoflor.zarco.domain.station.usecase.impl

import com.github.gustavoflor.zarco.domain.station.LineStop
import com.github.gustavoflor.zarco.domain.station.exception.LineStopNotFoundException
import com.github.gustavoflor.zarco.domain.station.repository.LineStopRepository
import com.github.gustavoflor.zarco.domain.station.usecase.DeleteLineStopByIdUseCase
import com.github.gustavoflor.zarco.shared.mapping.UseCase
import java.util.UUID

@UseCase
class DeleteLineStopByIdUseCaseImpl(
    private val lineStopRepository: LineStopRepository
) : DeleteLineStopByIdUseCase {
    override fun execute(id: UUID) {
        val lineStop = findLineStopById(id)
        val nextLineStop = lineStopRepository.findByLineIdAndParentId(lineStop.lineId, id)
        if (nextLineStop != null) {
            lineStop.let { lineStopRepository.update(it.copy(parentId = it.id)) }
            nextLineStop.let { lineStopRepository.update(it.copy(parentId = lineStop.parentId)) }
        }
        lineStopRepository.deleteById(lineStop.id)
    }

    private fun findLineStopById(id: UUID): LineStop {
        return lineStopRepository.findById(id) ?: throw LineStopNotFoundException()
    }
}
