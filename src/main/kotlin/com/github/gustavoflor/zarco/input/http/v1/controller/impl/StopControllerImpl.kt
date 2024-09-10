package com.github.gustavoflor.zarco.input.http.v1.controller.impl

import com.github.gustavoflor.zarco.domain.station.usecase.CreateStopUseCase
import com.github.gustavoflor.zarco.input.http.v1.controller.StopController
import com.github.gustavoflor.zarco.input.http.v1.dto.request.CreateStopRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.StopData
import org.springframework.web.bind.annotation.RestController

@RestController
class StopControllerImpl(
    private val createStopUseCase: CreateStopUseCase
) : StopController {
    override fun create(request: CreateStopRequestData): StopData {
        val input = request.input()
        val output = createStopUseCase.execute(input)
        return StopData.of(output.stop)
    }
}
