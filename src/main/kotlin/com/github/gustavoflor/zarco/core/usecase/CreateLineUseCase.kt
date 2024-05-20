package com.github.gustavoflor.zarco.core.usecase

import com.github.gustavoflor.zarco.core.entity.Line

interface CreateLineUseCase {
    fun execute(input: Input): Output

    data class Input(val lineName: String)

    data class Output(val line: Line)
}
