package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.impl

import com.github.gustavoflor.zarco.core.port.command.CreateStationLineCommand
import com.github.gustavoflor.zarco.core.port.command.DeleteStationLineCommand
import com.github.gustavoflor.zarco.core.port.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.StationController
import com.github.gustavoflor.zarco.core.usecase.CreateStationUseCase
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.request.CreateStationRequest
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.response.StationResponse
import com.github.gustavoflor.zarco.entrypoint.web.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.RestController

@RestController("v1/StationController")
class StationControllerImpl(
    private val findStationByIdQuery: FindStationByIdQuery,
    private val createStationUseCase: CreateStationUseCase,
    private val createStationLineCommand: CreateStationLineCommand,
    private val deleteStationLineCommand: DeleteStationLineCommand
) : StationController {
    override fun create(requestBody: CreateStationRequest): StationResponse {
        val input = CreateStationUseCase.Input(requestBody.name)
        val output = createStationUseCase.execute(input)
        return StationResponse.of(output.station)
    }

    @Deprecated("Deprecated endpoint, you should migrate to `GET /v2/stations` until 2024/05")
    override fun findById(id: Long): StationResponse {
        return findStationByIdQuery.execute(id)
            ?.let(StationResponse::of)
            ?: throw ResourceNotFoundException("Station not found")
    }

    override fun linkLine(id: Long, lineId: Long) {
        createStationLineCommand.execute(
            stationId = id,
            lineId = lineId
        )
    }

    override fun unlinkLine(id: Long, lineId: Long) {
        deleteStationLineCommand.execute(
            stationId = id,
            lineId = lineId
        )
    }
}
