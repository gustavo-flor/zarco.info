package com.github.gustavoflor.zarco.input.http.v1.controller.impl

import com.github.gustavoflor.zarco.domain.station.service.StationService
import com.github.gustavoflor.zarco.domain.station.usecase.CreateStationUseCase
import com.github.gustavoflor.zarco.input.http.v1.controller.StationController
import com.github.gustavoflor.zarco.input.http.v1.dto.request.CreateStationRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.StationData
import com.github.gustavoflor.zarco.input.http.v1.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.RestController

@RestController
class StationControllerImpl(
    private val createStationUseCase: CreateStationUseCase,
    private val stationService: StationService
) : StationController {
    override fun create(request: CreateStationRequestData): StationData {
        val input = request.input()
        val output = createStationUseCase.execute(input)
        return StationData.of(output.station)
    }

    override fun findByExternalId(externalId: String): StationData {
        val station = stationService.findByExternalId(externalId)
            ?: throw ResourceNotFoundException("Station not found")
        return StationData.of(station)
    }

    override fun findAll(): List<StationData> {
        return stationService.findAll().map { StationData.of(it) }
    }
}
