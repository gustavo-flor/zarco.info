package com.github.gustavoflor.zarco.core.port.command

interface CreateStationLineCommand {
    fun execute(stationId: Long, lineId: Long)
}
