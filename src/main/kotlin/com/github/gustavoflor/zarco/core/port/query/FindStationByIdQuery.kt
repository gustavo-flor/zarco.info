package com.github.gustavoflor.zarco.core.port.query

import com.github.gustavoflor.zarco.core.entity.Station

interface FindStationByIdQuery {
    fun execute(id: Long): Station?
}