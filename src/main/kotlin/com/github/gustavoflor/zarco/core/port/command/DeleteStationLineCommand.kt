package com.github.gustavoflor.zarco.core.port.command

interface DeleteStationLineCommand {
    fun execute(stationId: Long, lineId: Long)
}
