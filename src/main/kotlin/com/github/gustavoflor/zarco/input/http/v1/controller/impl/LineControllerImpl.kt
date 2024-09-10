package com.github.gustavoflor.zarco.input.http.v1.controller.impl

import com.github.gustavoflor.zarco.domain.station.service.LineService
import com.github.gustavoflor.zarco.domain.station.usecase.CreateLineStopsUseCase
import com.github.gustavoflor.zarco.domain.station.usecase.CreateLineUseCase
import com.github.gustavoflor.zarco.input.http.v1.controller.LineController
import com.github.gustavoflor.zarco.input.http.v1.dto.request.CreateLineRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.request.LinkStopsRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.LineData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.LineStopData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.LineStopsResponse
import com.github.gustavoflor.zarco.input.http.v1.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class LineControllerImpl(
    private val createLineUseCase: CreateLineUseCase,
    private val createLineStopsUseCase: CreateLineStopsUseCase,
    private val lineService: LineService
) : LineController {
    override fun create(request: CreateLineRequestData): LineData {
        val input = request.input()
        val output = createLineUseCase.execute(input)
        return LineData.of(output.line)
    }

    override fun linkStops(lineId: UUID, request: LinkStopsRequestData): List<LineStopData> {
        val input = request.input(lineId)
        val output = createLineStopsUseCase.execute(input)
        return output.lineStops.map { LineStopData.of(it) }
    }

    override fun findByExternalId(externalId: String): LineData {
        val line = lineService.findByExternalId(externalId)
            ?: throw ResourceNotFoundException("Line not found")
        return LineData.of(line)
    }
}
