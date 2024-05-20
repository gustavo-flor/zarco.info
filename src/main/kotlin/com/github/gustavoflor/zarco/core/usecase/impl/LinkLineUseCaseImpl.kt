package com.github.gustavoflor.zarco.core.usecase.impl

import com.github.gustavoflor.zarco.core.command.CreateStationLineCommand
import com.github.gustavoflor.zarco.core.usecase.LinkLineUseCase
import org.apache.logging.log4j.LogManager
import org.springframework.dao.DuplicateKeyException
import org.springframework.stereotype.Component

@Component
class LinkLineUseCaseImpl(
    private val createStationLineCommand: CreateStationLineCommand
) : LinkLineUseCase {
    private val log = LogManager.getLogger(javaClass)

    override fun execute(input: LinkLineUseCase.Input) {
        try {
            return createStationLineCommand.execute(
                stationId = input.stationId,
                lineId = input.lineId
            )
        } catch (e: DuplicateKeyException) {
            log.warn("Line already linked with station", e)
            throw e
        }
    }
}
