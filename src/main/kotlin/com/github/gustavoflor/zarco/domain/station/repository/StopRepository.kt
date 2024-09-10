package com.github.gustavoflor.zarco.domain.station.repository

import com.github.gustavoflor.zarco.domain.station.Stop

interface StopRepository {
    fun save(stop: Stop): Stop
}
