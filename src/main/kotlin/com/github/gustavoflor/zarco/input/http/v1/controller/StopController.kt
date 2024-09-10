package com.github.gustavoflor.zarco.input.http.v1.controller

import com.github.gustavoflor.zarco.input.http.v1.dto.request.CreateStopRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.StopData
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("/v1/stops")
interface StopController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: CreateStopRequestData): StopData
}
