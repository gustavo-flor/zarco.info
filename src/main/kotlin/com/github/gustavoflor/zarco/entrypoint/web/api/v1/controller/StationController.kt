package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller

import com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.request.CreateStationRequest
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.response.StationResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RequestMapping("/v1/stations")
interface StationController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody requestBody: CreateStationRequest): StationResponse

    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable id: Long): StationResponse
}
