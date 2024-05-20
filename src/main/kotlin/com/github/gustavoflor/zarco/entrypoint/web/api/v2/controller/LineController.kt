package com.github.gustavoflor.zarco.entrypoint.web.api.v2.controller

import com.github.gustavoflor.zarco.entrypoint.web.api.v2.dto.response.LineResponse
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Validated
@RequestMapping("/v2/lines")
interface LineController {
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<LineResponse>
}
