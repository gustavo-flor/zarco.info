package com.github.gustavoflor.zarco.entrypoint.web.api.v2.dto.response

import com.github.gustavoflor.zarco.core.entity.Station

data class StationResponse(
    val id: Long,
    val name: String
) {

    companion object {
        fun of(station: Station): StationResponse = StationResponse(
            id = station.id!!,
            name = station.name
        )
    }

}