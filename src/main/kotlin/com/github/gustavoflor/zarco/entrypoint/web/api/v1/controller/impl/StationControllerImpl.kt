package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.impl

import com.github.gustavoflor.zarco.core.port.FindStationByIdQuery
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.StationController
import com.github.gustavoflor.zarco.core.usecase.CreateStationUseCase
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.request.CreateStationRequest
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.response.StationResponse
import com.github.gustavoflor.zarco.entrypoint.web.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.RestController

@RestController("v1/StationController")
class StationControllerImpl(
    private val findStationByIdQuery: FindStationByIdQuery,
    private val createStationUseCase: CreateStationUseCase
) : StationController {

    override fun create(requestBody: CreateStationRequest): StationResponse {
        val input = CreateStationUseCase.Input(requestBody.name)
        val output = createStationUseCase.execute(input)
        return StationResponse.of(output.station)
    }

    override fun findById(id: Long): StationResponse {
        return findStationByIdQuery.execute(id)
            ?.let(StationResponse::of)
            ?: throw ResourceNotFoundException("Station not found")
    }

}