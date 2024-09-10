package com.github.gustavoflor.zarco.domain.station.service

import com.github.gustavoflor.zarco.domain.station.repository.StationRepository
import org.springframework.stereotype.Service

@Service
class StationService(
    private val stationRepository: StationRepository
) {
    fun findByExternalId(externalId: String) = stationRepository.findByExternalId(externalId)

    fun findAll() = stationRepository.findAll()
}
