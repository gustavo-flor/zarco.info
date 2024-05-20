package com.github.gustavoflor.zarco.core.port.query

import com.github.gustavoflor.zarco.core.entity.Line

interface FindLinesByStationIdQuery {
    fun execute(stationId: Long): List<Line>
}
