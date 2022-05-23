package com.github.gustavoflor.zarco.service;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import com.github.gustavoflor.zarco.entity.Line;
import com.github.gustavoflor.zarco.repository.LineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineService {
    private final LineRepository lineRepository;

    public Line create(final CreateLineDTO dto) {
        return lineRepository.save(Line.of(dto));
    }

    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    public void deleteById(final Long id) {
        lineRepository.deleteById(id);
    }
}
