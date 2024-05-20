package com.github.gustavoflor.zarco.core.usecase.impl

import com.github.gustavoflor.zarco.core.model.Station
import com.github.gustavoflor.zarco.core.command.CreateStationCommand
import com.github.gustavoflor.zarco.core.usecase.CreateStationUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateStationUseCaseImpl(
    private val createStationCommand: CreateStationCommand
): CreateStationUseCase {
    private val log = LoggerFactory.getLogger(javaClass)

    @Transactional
    override fun execute(input: CreateStationUseCase.Input): CreateStationUseCase.Output {
        val station = createStationCommand.execute(
            station = Station(name = input.stationName)
        )
        log.info("Successfully created new station: $station")
        return CreateStationUseCase.Output(station)
    }
}
