package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.impl

import com.github.gustavoflor.zarco.core.command.DeleteStationLineCommand
import com.github.gustavoflor.zarco.core.query.FindLinesByStationIdQuery
import com.github.gustavoflor.zarco.core.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.StationController
import com.github.gustavoflor.zarco.core.usecase.CreateStationUseCase
import com.github.gustavoflor.zarco.core.usecase.LinkLineUseCase
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.request.CreateStationSchema
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.LineSchema
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.StationSchema
import com.github.gustavoflor.zarco.entrypoint.web.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.RestController

@RestController("v1/StationController")
class StationControllerImpl(
    private val findStationByIdQuery: FindStationByIdQuery,
    private val createStationUseCase: CreateStationUseCase,
    private val linkLineUseCase: LinkLineUseCase,
    private val deleteStationLineCommand: DeleteStationLineCommand,
    private val findLinesByStationIdQuery: FindLinesByStationIdQuery
) : StationController {
    override fun create(requestBody: CreateStationSchema): StationSchema {
        val input = CreateStationUseCase.Input(requestBody.name)
        val output = createStationUseCase.execute(input)
        return StationSchema.of(output.station)
    }

    override fun findById(id: Long) = findStationByIdQuery.execute(id)
        ?.let(StationSchema::of)
        ?: throw ResourceNotFoundException("Station not found")

    override fun linkLine(id: Long, lineId: Long) = linkLineUseCase.execute(LinkLineUseCase.Input(id, lineId))

    override fun findLinesById(id: Long) = findLinesByStationIdQuery.execute(id)
        .map { LineSchema.of(it) }

    override fun unlinkLine(id: Long, lineId: Long) = deleteStationLineCommand.execute(
        stationId = id,
        lineId = lineId
    )
}
