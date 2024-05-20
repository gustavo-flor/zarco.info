package com.github.gustavoflor.zarco.core.command

interface CreateStationLineCommand {
    fun execute(stationId: Long, lineId: Long)
}
