package com.github.gustavoflor.zarco.domain.station.usecase

import java.util.UUID

interface DeleteLineStopByIdUseCase {
    fun execute(id: UUID)
}
