package com.github.gustavoflor.zarco.entrypoint.web.api.v2.controller.impl

import com.github.gustavoflor.zarco.core.port.query.FindStationByIdQuery
import com.github.gustavoflor.zarco.entrypoint.web.api.v2.controller.StationController
import com.github.gustavoflor.zarco.entrypoint.web.api.v2.dto.response.StationResponse
import com.github.gustavoflor.zarco.entrypoint.web.exception.ResourceNotFoundException
import org.springframework.web.bind.annotation.RestController

@RestController("v2/StationController")
class StationControllerImpl(
    private val findStationByIdQuery: FindStationByIdQuery
) : StationController {

    override fun findById(id: Long): StationResponse {
        return findStationByIdQuery.execute(id)
            ?.let(StationResponse::of)
            ?: throw ResourceNotFoundException("Station not found")
    }

}