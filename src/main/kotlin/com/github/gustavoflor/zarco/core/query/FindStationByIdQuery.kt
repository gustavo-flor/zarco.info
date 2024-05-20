package com.github.gustavoflor.zarco.core.query

import com.github.gustavoflor.zarco.core.model.Station

interface FindStationByIdQuery {
    fun execute(id: Long): Station?
}