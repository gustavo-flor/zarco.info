package com.github.gustavoflor.zarco.output.data.repository

import com.github.gustavoflor.zarco.domain.station.Station
import com.github.gustavoflor.zarco.domain.station.repository.StationRepository
import com.github.gustavoflor.zarco.output.data.command.CreateStationCommand
import com.github.gustavoflor.zarco.output.data.query.FindStationByExternalIdQuery
import com.github.gustavoflor.zarco.output.data.query.FindStationsQuery
import org.springframework.stereotype.Repository

@Repository
class StationRepositoryImpl(
    private val createStationCommand: CreateStationCommand,
    private val findStationByExternalIdQuery: FindStationByExternalIdQuery,
    private val findStationsQuery: FindStationsQuery
) : StationRepository {
    override fun save(station: Station): Station = createStationCommand.execute(station)

    override fun findByExternalId(externalId: String): Station? = findStationByExternalIdQuery.execute(externalId)

    override fun findAll(): List<Station> = findStationsQuery.execute()
}
