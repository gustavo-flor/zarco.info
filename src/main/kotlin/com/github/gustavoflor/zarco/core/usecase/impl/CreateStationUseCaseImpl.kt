package com.github.gustavoflor.zarco.core.usecase.impl

import com.github.gustavoflor.zarco.core.entity.Station
import com.github.gustavoflor.zarco.core.event.NewStationEvent
import com.github.gustavoflor.zarco.core.event.publisher.NewStationEventPublisher
import com.github.gustavoflor.zarco.core.port.command.CreateStationCommand
import com.github.gustavoflor.zarco.core.usecase.CreateStationUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CreateStationUseCaseImpl(
    private val createStationCommand: CreateStationCommand,
    private val newStationEventPublisher: NewStationEventPublisher
): CreateStationUseCase {
    private val log = LoggerFactory.getLogger(javaClass)

    @Transactional
    override fun execute(input: CreateStationUseCase.Input): CreateStationUseCase.Output {
        val station = createStationCommand.execute(
            station = Station(name = input.stationName)
        )
        log.info("Successfully created new station: $station")
        newStationEventPublisher.execute(NewStationEvent(station))
        return CreateStationUseCase.Output(station)
    }
}
