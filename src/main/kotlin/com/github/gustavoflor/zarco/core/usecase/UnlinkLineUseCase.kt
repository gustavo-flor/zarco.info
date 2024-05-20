package com.github.gustavoflor.zarco.core.usecase

interface UnlinkLineUseCase {
    fun execute(input: Input)

    data class Input(val stationId: Long, val lineId: Long)
}
