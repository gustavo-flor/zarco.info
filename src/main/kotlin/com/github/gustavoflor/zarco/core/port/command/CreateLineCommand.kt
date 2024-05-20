package com.github.gustavoflor.zarco.core.port.command

import com.github.gustavoflor.zarco.core.entity.Line

interface CreateLineCommand {
    fun execute(line: Line): Line
}
