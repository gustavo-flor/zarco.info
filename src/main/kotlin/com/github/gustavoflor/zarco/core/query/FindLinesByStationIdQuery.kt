package com.github.gustavoflor.zarco.core.query

import com.github.gustavoflor.zarco.core.model.Line

interface FindLinesByStationIdQuery {
    fun execute(stationId: Long): List<Line>
}
