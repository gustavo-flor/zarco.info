package com.github.gustavoflor.zarco.service;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import com.github.gustavoflor.zarco.entity.Line;
import com.github.gustavoflor.zarco.exception.LineNameAlreadyInUseException;
import com.github.gustavoflor.zarco.repository.LineRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LineServiceImplTest {
    static final Faker FAKER = new Faker();

    @InjectMocks
    LineServiceImpl lineService;

    @Mock
    LineRepository lineRepository;

    @Test
    @DisplayName("Given an ID when delete by id, then should call delete on repository")
    void givenAnIdWhenDeleteByIdThenShouldCallDeleteOnRepository() {
        final var id = FAKER.number().randomNumber();
        lineService.deleteById(id);
        verify(lineRepository).existsById(id);
        verify(lineRepository, never()).deleteById(id);
    }

    @Test
    @DisplayName("When find all, then should call find all on repository")
    void whenFindAllThenShouldCallFindAllOnRepository() {
        lineService.findAll();
        verify(lineRepository).findAll();
    }

    @Test
    @DisplayName("Given a line DTO when create, then should call save on repository")
    void givenALineDTOWhenCreateThenShouldCallSaveOnRepository() {
        final var dto = new CreateLineDTO(FAKER.address().streetName());
        lineService.create(dto);
        final var lineCaptor = ArgumentCaptor.forClass(Line.class);
        verify(lineRepository).save(lineCaptor.capture());
        final var line = lineCaptor.getValue();
        assertThat(line.getId()).isNull();
        assertThat(line.getName()).isEqualTo(dto.name());
    }

    @Test
    @DisplayName("Given a line DTO with name already in use when create, then should throw LineNameAlreadyInUseException")
    void givenALineDTOWithNameAlreadyInUseWhenCreateThenShouldThrowLineNameAlreadyInUseException() {
        final var dto = new CreateLineDTO(FAKER.address().streetName());
        doReturn(true).when(lineRepository).existsByName(dto.name());
        assertThatThrownBy(() -> lineService.create(dto)).isInstanceOf(LineNameAlreadyInUseException.class);
    }
}
