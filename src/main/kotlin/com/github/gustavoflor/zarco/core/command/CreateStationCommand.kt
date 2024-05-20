package com.github.gustavoflor.zarco.core.command

import com.github.gustavoflor.zarco.core.model.Station

interface CreateStationCommand {
    fun execute(station: Station): Station
}