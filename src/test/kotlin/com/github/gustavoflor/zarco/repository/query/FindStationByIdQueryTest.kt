package com.github.gustavoflor.zarco.repository.query

import com.github.gustavoflor.zarco.CoreTest
import com.github.gustavoflor.zarco.WebApplication
import com.github.gustavoflor.zarco.core.query.FindStationByIdQuery
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import java.time.LocalDateTime
import kotlin.random.Random

@Sql(value = ["classpath:sql/create-station-table.sql", "classpath:sql/insert-station-table.sql"])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = [WebApplication::class])
class FindStationByIdQueryTest : CoreTest() {

    @Autowired
    private lateinit var query: FindStationByIdQuery

    @Test
    fun `Given an ID, When execute query, Then should find a station`() {
        val now = LocalDateTime.now()
        val lastHour = LocalDateTime.now().minusHours(1)
        val stationNames = mapOf(
            1L to "Brooklyn",
            2L to "Terminus",
            3L to "Carolina"
        )
        val id = Random.nextLong(1, 4)

        val station = query.execute(id)

        assertThat(station?.id).isEqualTo(id)
        assertThat(station?.name).isEqualTo(stationNames[id])
        assertThat(station?.createdAt).isBetween(lastHour, now)
        assertThat(station?.updatedAt).isBetween(lastHour, now)
    }

}