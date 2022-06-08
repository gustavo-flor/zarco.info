package com.github.gustavoflor.zarco.service;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import com.github.gustavoflor.zarco.entity.Line;

import java.util.List;

public interface LineService {
    Line create(final CreateLineDTO dto);

    List<Line> findAll();

    void deleteById(final Long id);
}
