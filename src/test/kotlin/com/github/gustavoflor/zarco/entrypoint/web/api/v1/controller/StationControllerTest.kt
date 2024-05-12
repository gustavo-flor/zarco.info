package com.github.gustavoflor.zarco.entrypoint.web.api.v1.controller

import com.github.gustavoflor.zarco.entrypoint.web.api.ApiTest
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.Endpoints
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.test.context.jdbc.Sql
import kotlin.random.Random

@Sql("classpath:sql/create-station-table.sql")
class StationControllerTest : ApiTest() {

    @Test
    fun `Given a non-existent ID, When find, Then should return 404`() {
        val id = Random.nextLong(1, 100)

        Endpoints.StationController.findById(id)
            .statusCode(HttpStatus.NOT_FOUND.value())
            .body("code", equalTo("RESOURCE_NOT_FOUND"))
            .body("message", equalTo("Station not found"))
    }

}