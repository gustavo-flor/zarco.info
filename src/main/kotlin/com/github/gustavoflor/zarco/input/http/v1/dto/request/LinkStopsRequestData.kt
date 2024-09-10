package com.github.gustavoflor.zarco.input.http.v1.dto.request

import com.github.gustavoflor.zarco.domain.station.usecase.CreateLineStopsUseCase
import jakarta.validation.constraints.NotEmpty
import java.util.UUID

data class LinkStopsRequestData(
    val parentId: UUID? = null,
    @field:NotEmpty
    val stopIds: List<UUID>? = null,
) {
    fun input(lineId: UUID) = CreateLineStopsUseCase.Input(
        parentId = parentId,
        lineId = lineId,
        stopIds = stopIds!!
    )
}
