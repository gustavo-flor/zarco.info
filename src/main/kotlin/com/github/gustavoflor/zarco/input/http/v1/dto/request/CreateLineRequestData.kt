package com.github.gustavoflor.zarco.input.http.v1.dto.request

import com.github.gustavoflor.zarco.domain.station.usecase.CreateLineUseCase
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.util.UUID

data class CreateLineRequestData(
    @field:NotBlank
    @field:Size(max = 128)
    val name: String? = null,
    @field:NotBlank
    @field:Size(max = 128)
    val externalId: String? = null,
    val stationIds: List<UUID>? = null
) {
    fun input() = CreateLineUseCase.Input(
        name = name!!,
        externalId = externalId!!,
        stationIds = stationIds?.distinct() ?: emptyList()
    )
}
