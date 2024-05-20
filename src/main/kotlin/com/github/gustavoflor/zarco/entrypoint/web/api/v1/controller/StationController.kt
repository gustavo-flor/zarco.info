package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller

import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.request.CreateStationSchema
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.LineSchema
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.StationSchema
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
    fun create(@Valid @RequestBody requestBody: CreateStationSchema): StationSchema

    @GetMapping(path = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable id: Long): StationSchema

    @PutMapping(path = ["/{id}/lines/{lineId}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun linkLine(@PathVariable id: Long, @PathVariable lineId: Long)

    @GetMapping(path = ["/{id}/lines"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findLinesById(@PathVariable id: Long): List<LineSchema>

    @DeleteMapping(path = ["/{id}/lines/{lineId}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun unlinkLine(@PathVariable id: Long, @PathVariable lineId: Long)
}
