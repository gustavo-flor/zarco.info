package com.github.gustavoflor.zarco.core.command

import com.github.gustavoflor.zarco.core.model.Line

interface CreateLineCommand {
    fun execute(line: Line): Line
}
