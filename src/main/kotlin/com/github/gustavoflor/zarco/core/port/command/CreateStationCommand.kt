package com.github.gustavoflor.zarco.core.port.command

import com.github.gustavoflor.zarco.core.entity.Station

interface CreateStationCommand {
    fun execute(station: Station): Station
}