package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.impl

import com.github.gustavoflor.zarco.core.usecase.CreateLineUseCase
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller.LineController
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.request.CreateLineSchema
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.LineSchema
import org.springframework.web.bind.annotation.RestController

@RestController("v1/LineController")
class LineControllerImpl(
    private val createLineUseCase: CreateLineUseCase
) : LineController {
    override fun create(requestBody: CreateLineSchema): LineSchema {
        val input = CreateLineUseCase.Input(requestBody.name)
        val output = createLineUseCase.execute(input)
        return LineSchema.of(output.line)
    }
}
