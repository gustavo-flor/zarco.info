package com.github.gustavoflor.zarco.output.data.repository

import com.github.gustavoflor.zarco.domain.station.Stop
import com.github.gustavoflor.zarco.domain.station.repository.StopRepository
import com.github.gustavoflor.zarco.output.data.command.CreateStopCommand
import org.springframework.stereotype.Repository

@Repository
class StopRepositoryImpl(
    private val createStopCommand: CreateStopCommand
) : StopRepository {
    override fun save(stop: Stop): Stop = createStopCommand.execute(stop)
}
