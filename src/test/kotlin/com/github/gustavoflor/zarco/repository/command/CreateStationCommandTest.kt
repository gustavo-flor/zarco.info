package com.github.gustavoflor.zarco.repository.command

import com.github.gustavoflor.zarco.CoreTest
import com.github.gustavoflor.zarco.WebApplication
import com.github.gustavoflor.zarco.core.entity.Station
import com.github.gustavoflor.zarco.core.port.command.CreateStationCommand
import com.github.gustavoflor.zarco.adapter.repository.mapper.StationMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql

@Sql("classpath:sql/create-station-table.sql")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = [WebApplication::class])
class CreateStationCommandTest : CoreTest() {

    @Autowired
    private lateinit var command: CreateStationCommand

    @Autowired
    @Qualifier("readWriteNamedParameterJdbcTemplate")
    private lateinit var jdbcTemplate: NamedParameterJdbcTemplate

    @AfterEach
    fun tearDown() {
        jdbcTemplate.update("DELETE FROM station WHERE ${1} = ${1}", mapOf<String, Any>())
    }

    @Test
    fun `Given a station, When execute command, Then should persist a station`() {
        val station = Station(name = "King's Cross")

        val savedStation = command.execute(station)

        assertThat(savedStation.id).isNotNull()
        assertThat(savedStation.name).isEqualTo(station.name)
        assertThat(savedStation.createdAt).isEqualTo(station.createdAt)
        assertThat(savedStation.updatedAt).isEqualTo(station.updatedAt)
        val searchedStation = searchStationById(savedStation.id!!)
        assertThat(searchedStation).isEqualTo(savedStation)
    }

    private fun searchStationById(id: Long): Station? {
        return try {
            jdbcTemplate.queryForObject("SELECT * FROM station WHERE id = :id", mapOf("id" to id), StationMapper())
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }

}