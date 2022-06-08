package com.github.gustavoflor.zarco.controller;

import com.github.gustavoflor.zarco.AbstractComponentTest;
import com.github.gustavoflor.zarco.api.LineApi;
import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import com.github.gustavoflor.zarco.entity.Line;
import com.github.gustavoflor.zarco.repository.LineRepository;
import com.github.javafaker.Faker;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.mockito.Mockito.*;

class LineControllerComponentTest extends AbstractComponentTest {
    static final Faker FAKER = new Faker();

    @Override
    @BeforeEach
    public void beforeEach() {
        super.beforeEach();
        lineRepository.deleteAll();
    }

    @SpyBean
    LineController lineController;

    @SpyBean
    LineRepository lineRepository;

    @Test
    @DisplayName("Given an invalid id when delete by id, then should not execute delete by id")
    void givenAnInvalidIdWhenDeleteByIdThenShouldNotExecuteDeleteById() {
        final var id = FAKER.number().randomNumber();
        LineApi.deleteById(id).statusCode(HttpStatus.NO_CONTENT.value());
        verify(lineController).deleteById(id);
    }

    @Test
    @DisplayName("Given a valid id when delete by id, then should delete line")
    void givenAValidIdWhenDeleteByIdThenShouldDeleteLine() {
        final var dto = new CreateLineDTO(FAKER.address().streetName());
        final var line = lineRepository.save(Line.of(dto));
        LineApi.deleteById(line.getId()).statusCode(HttpStatus.NO_CONTENT.value());
        verify(lineController).deleteById(line.getId());
    }

    @Test
    @DisplayName("Given a call without lines when find all, then should return empty result")
    void givenACallWithoutLinesWhenFindAllThenShouldReturnEmptyResult() {
        LineApi.findAll()
                .statusCode(HttpStatus.OK.value())
                .body("$", Matchers.hasSize(0));
        verify(lineController).findAll();
    }

    @Test
    @DisplayName("Given a call with lines when find all, then should return non empty result")
    void givenACallWithLinesWhenFindAllThenShouldReturnNonEmptyResult() {
        final var lines = List.of(
                Line.of(new CreateLineDTO(FAKER.address().streetName())),
                Line.of(new CreateLineDTO(FAKER.address().streetName())),
                Line.of(new CreateLineDTO(FAKER.address().streetName())),
                Line.of(new CreateLineDTO(FAKER.address().streetName()))
        );
        lineRepository.saveAll(lines);
        LineApi.findAll()
                .statusCode(HttpStatus.OK.value())
                .body("$", Matchers.hasSize(lines.size()));
        verify(lineController).findAll();
    }

    @Test
    @DisplayName("Given a valid payload when create, then should create line")
    void givenAValidPayloadWhenCreateThenShouldCreateLine() {
        final var dto = new CreateLineDTO(FAKER.address().streetName());
        LineApi.create(dto)
                .statusCode(HttpStatus.CREATED.value())
                .body("number", Matchers.notNullValue())
                .body("name", Matchers.equalTo(dto.name()));
        verify(lineController).create(dto);
    }
}