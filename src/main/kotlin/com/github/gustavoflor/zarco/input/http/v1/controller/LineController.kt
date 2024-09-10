package com.github.gustavoflor.zarco.input.http.v1.controller

import com.github.gustavoflor.zarco.input.http.v1.dto.request.CreateLineRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.request.LinkStopsRequestData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.LineData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.LineStopData
import com.github.gustavoflor.zarco.input.http.v1.dto.response.LineStopsResponse
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.UUID

@RequestMapping("/v1/lines")
interface LineController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: CreateLineRequestData): LineData

    @PostMapping(path = ["/{lineId}/stops"], consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun linkStops(@PathVariable lineId: UUID, @Valid @RequestBody request: LinkStopsRequestData): List<LineStopData>

    @GetMapping(path = ["/{externalId}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findByExternalId(@PathVariable externalId: String): LineData
}
