package com.github.gustavoflor.zarco.entrypoint.web.api.v1

import io.restassured.RestAssured
import io.restassured.http.ContentType
import io.restassured.response.ValidatableResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

class Endpoints {
    class StationController {
        companion object {
            fun findById(id: Long): ValidatableResponse {
                return RestAssured.given()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .get("/v1/stations/{id}", id)
                    .then()
            }
        }
    }
}