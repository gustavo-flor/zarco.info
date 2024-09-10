package com.github.gustavoflor.zarco.domain.station.exception

class LineStopNotFoundException(
    override val message: String = "Line stop not found"
) : RuntimeException(message)
