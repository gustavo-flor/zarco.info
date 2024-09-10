package com.github.gustavoflor.zarco.domain.station.usecase.impl

import com.github.gustavoflor.zarco.domain.station.repository.StopRepository
import com.github.gustavoflor.zarco.domain.station.usecase.CreateStopUseCase
import com.github.gustavoflor.zarco.shared.mapping.UseCase
import org.springframework.transaction.annotation.Transactional

@UseCase
class CreateStopUseCaseImpl(
    private val stopRepository: StopRepository
) : CreateStopUseCase {
    @Transactional
    override fun execute(input: CreateStopUseCase.Input): CreateStopUseCase.Output {
        val stop = stopRepository.save(input.stop())
        return CreateStopUseCase.Output(stop)
    }
}
