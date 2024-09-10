package com.github.gustavoflor.zarco.input.http.v1.dto.request

import com.github.gustavoflor.zarco.domain.station.usecase.CreateStationUseCase
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateStationRequestData(
    @field:NotBlank
    @field:Size(max = 128)
    val name: String? = null,
    @field:NotBlank
    @field:Size(max = 128)
    val externalId: String? = null,
) {
    fun input() = CreateStationUseCase.Input(
        name = name!!,
        externalId = externalId!!
    )
}
