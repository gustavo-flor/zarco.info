package com.github.gustavoflor.zarco.core.command

interface DeleteStationLineCommand {
    fun execute(stationId: Long, lineId: Long)
}
