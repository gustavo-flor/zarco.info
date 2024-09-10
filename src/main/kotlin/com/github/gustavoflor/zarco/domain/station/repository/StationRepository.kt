package com.github.gustavoflor.zarco.domain.station.repository

import com.github.gustavoflor.zarco.domain.station.Station

interface StationRepository {
    fun save(station: Station): Station

    fun findByExternalId(externalId: String): Station?

    fun findAll(): List<Station>
}
