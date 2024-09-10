package com.github.gustavoflor.zarco.output.data.repository

import com.github.gustavoflor.zarco.domain.station.Line
import com.github.gustavoflor.zarco.domain.station.repository.LineRepository
import com.github.gustavoflor.zarco.output.data.command.CreateLineCommand
import com.github.gustavoflor.zarco.output.data.query.FindLineByExternalIdQuery
import org.springframework.stereotype.Repository

@Repository
class LineRepositoryImpl(
    private val createLineCommand: CreateLineCommand,
    private val findLineByExternalIdQuery: FindLineByExternalIdQuery
) : LineRepository {
    override fun save(line: Line): Line = createLineCommand.execute(line)

    override fun findByExternalId(externalId: String): Line? = findLineByExternalIdQuery.execute(externalId)
}
