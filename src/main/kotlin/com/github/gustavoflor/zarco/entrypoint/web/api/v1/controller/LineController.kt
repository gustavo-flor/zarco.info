package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller

import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.request.CreateLineSchema
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.LineSchema
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus

@Validated
@RequestMapping("/v1/lines")
interface LineController {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody requestBody: CreateLineSchema): LineSchema
}