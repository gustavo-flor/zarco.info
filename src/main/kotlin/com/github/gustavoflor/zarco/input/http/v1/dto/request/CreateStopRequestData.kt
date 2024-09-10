package com.github.gustavoflor.zarco.input.http.v1.dto.request

import com.github.gustavoflor.zarco.domain.station.usecase.CreateStopUseCase
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateStopRequestData(
    @field:NotBlank
    @field:Size(max = 128)
    val name: String? = null,
    @field:NotNull
    @field:Min(-90)
    @field:Max(90)
    val latitude: Double? = null,
    @field:NotNull
    @field:Min(-180)
    @field:Max(180)
    val longitude: Double? = null
) {
    fun input() = CreateStopUseCase.Input(
        name = name!!,
        latitude = latitude!!,
        longitude = longitude!!
    )
}
