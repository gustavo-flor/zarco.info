package com.github.gustavoflor.zarco.adapter.repository.command

import com.github.gustavoflor.zarco.core.entity.Line
import com.github.gustavoflor.zarco.core.port.command.CreateLineCommand
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder

class CreateLineCommandImpl(
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
