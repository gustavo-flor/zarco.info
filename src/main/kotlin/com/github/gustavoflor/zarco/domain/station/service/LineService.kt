package com.github.gustavoflor.zarco.domain.station.service

import com.github.gustavoflor.zarco.domain.station.repository.LineRepository
import org.springframework.stereotype.Service

@Service
class LineService(
    private val lineRepository: LineRepository
) {
    fun findByExternalId(externalId: String) = lineRepository.findByExternalId(externalId)
}
