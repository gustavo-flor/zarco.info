package com.github.gustavoflor.zarco.api;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class LineApi {
    public static ValidatableResponse deleteById(final Long id) {
        return RestAssured.delete("/lines/{id}", id).then();
    }

    public static ValidatableResponse findAll() {
        return RestAssured.get("/lines").then();
    }

    public static ValidatableResponse create(final CreateLineDTO dto) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(dto)
                .post("/lines")
                .then();
    }
}
