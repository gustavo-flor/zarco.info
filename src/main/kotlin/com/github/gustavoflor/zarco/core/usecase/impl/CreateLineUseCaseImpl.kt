package com.github.gustavoflor.zarco.core.usecase.impl

import com.github.gustavoflor.zarco.core.model.Line
import com.github.gustavoflor.zarco.core.command.CreateLineCommand
import com.github.gustavoflor.zarco.core.usecase.CreateLineUseCase
import org.springframework.stereotype.Component

@Component
class CreateLineUseCaseImpl(
    private val createLineCommand: CreateLineCommand
) : CreateLineUseCase {
    override fun execute(input: CreateLineUseCase.Input): CreateLineUseCase.Output {
        val line = createLineCommand.execute(
            line = Line(name = input.lineName)
        )
        return CreateLineUseCase.Output(line)
    }
}
