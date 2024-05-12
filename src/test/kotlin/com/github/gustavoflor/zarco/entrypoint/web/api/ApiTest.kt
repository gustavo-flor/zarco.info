package com.github.gustavoflor.zarco.entrypoint.web.api

import com.github.gustavoflor.zarco.CoreTest
import com.github.gustavoflor.zarco.WebApplication
import io.restassured.RestAssured
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = [WebApplication::class])
abstract class ApiTest : CoreTest() {

    @LocalServerPort
    private lateinit var port: String

    @BeforeEach
    fun setUp() {
        RestAssured.baseURI = "http://localhost:$port/zarco-api"
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()
    }

    @Test
    fun `Given a local server port, When start API test, Then Should not be blank`() {
        assertThat(port).isNotBlank()
    }

}