package com.github.gustavoflor.zarco.entrypoint.web.api.v2.controller

import com.github.gustavoflor.zarco.entrypoint.web.api.v2.dto.response.StationResponse
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@Validated
@RequestMapping("/v2/stations")
interface StationController {

    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable id: Long): StationResponse

}