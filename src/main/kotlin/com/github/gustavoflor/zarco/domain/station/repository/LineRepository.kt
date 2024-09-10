package com.github.gustavoflor.zarco.domain.station.repository

import com.github.gustavoflor.zarco.domain.station.Line

interface LineRepository {
    fun save(line: Line): Line

    fun findByExternalId(externalId: String): Line?
}
