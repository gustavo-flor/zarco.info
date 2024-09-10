package com.github.gustavoflor.zarco.domain.station.usecase.impl

import com.github.gustavoflor.zarco.domain.station.StationLine
import com.github.gustavoflor.zarco.domain.station.repository.LineRepository
import com.github.gustavoflor.zarco.domain.station.repository.StationLineRepository
import com.github.gustavoflor.zarco.domain.station.usecase.CreateLineUseCase
import com.github.gustavoflor.zarco.shared.mapping.UseCase
import org.springframework.transaction.annotation.Transactional

@UseCase
class CreateLineUseCaseImpl(
    private val lineRepository: LineRepository,
    private val stationLineRepository: StationLineRepository
) : CreateLineUseCase {
    @Transactional
    override fun execute(input: CreateLineUseCase.Input): CreateLineUseCase.Output {
        val line = lineRepository.save(input.line())
        val stationLines = input.stationIds
            .map { StationLine.new(it, line.id) }
            .let { stationLineRepository.saveAll(it) }
        return CreateLineUseCase.Output(line, stationLines)
    }
}
