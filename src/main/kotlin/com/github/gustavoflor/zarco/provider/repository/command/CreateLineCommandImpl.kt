package com.github.gustavoflor.zarco.provider.repository.command

import com.github.gustavoflor.zarco.core.command.CreateLineCommand
import com.github.gustavoflor.zarco.core.model.Line
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.stereotype.Repository

@Repository
class CreateLineCommandImpl(
    @Qualifier("readWriteNamedParameterJdbcTemplate")
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : CreateLineCommand {
    companion object {
        private const val SQL = "INSERT INTO line (name, created_at, updated_at) VALUES (:name, :created_at, :updated_at)"
    }

    override fun execute(line: Line): Line {
        val params = mapOf(
            "name" to line.name,
            "created_at" to line.createdAt,
            "updated_at" to line.updatedAt
        )
        val keyHolder = GeneratedKeyHolder()
        jdbcTemplate.update(SQL, MapSqlParameterSource(params), keyHolder, arrayOf("id"))
        return line.copy(id = keyHolder.key!!.toLong())
    }
}
