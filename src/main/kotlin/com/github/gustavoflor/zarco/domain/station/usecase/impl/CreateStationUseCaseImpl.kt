package com.github.gustavoflor.zarco.domain.station.usecase.impl

import com.github.gustavoflor.zarco.domain.station.repository.StationRepository
import com.github.gustavoflor.zarco.domain.station.usecase.CreateStationUseCase
import com.github.gustavoflor.zarco.shared.mapping.UseCase
import org.springframework.transaction.annotation.Transactional

@UseCase
class CreateStationUseCaseImpl(
    private val stationRepository: StationRepository
) : CreateStationUseCase {
    @Transactional
    override fun execute(input: CreateStationUseCase.Input): CreateStationUseCase.Output {
        val station = input.station().let { stationRepository.save(it) }
        return CreateStationUseCase.Output(station)
    }
}
