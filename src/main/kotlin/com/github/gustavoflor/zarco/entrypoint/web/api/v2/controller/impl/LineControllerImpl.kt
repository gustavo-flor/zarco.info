package com.github.gustavoflor.zarco.entrypoint.web.api.v2.controller.impl

import com.github.gustavoflor.zarco.entrypoint.web.api.v2.controller.LineController
import com.github.gustavoflor.zarco.entrypoint.web.api.v2.dto.response.LineResponse
import org.springframework.web.bind.annotation.RestController

@RestController("v2/LineController")
class LineControllerImpl : LineController {

    override fun findAll(): List<LineResponse> = emptyList()

}