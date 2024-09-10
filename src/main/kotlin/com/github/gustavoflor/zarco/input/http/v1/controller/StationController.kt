package com.github.gustavoflor.zarco.input.http.v1.controller

import com.github.gustavoflor.zarco.input.http.v1.dto.request.CreateStationRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.StationData
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/v1/stations")
interface StationController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: CreateStationRequestData): StationData

    @GetMapping(path = ["/{externalId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findByExternalId(@PathVariable externalId: String): StationData

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<StationData>
}
