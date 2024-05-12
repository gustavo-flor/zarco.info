package com.github.gustavoflor.zarco.core.port

import com.github.gustavoflor.zarco.core.entity.Station

interface FindStationByIdQuery {

    fun execute(id: Long): Station?

}