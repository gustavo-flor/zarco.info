package com.github.gustavoflor.zarco.service;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import com.github.gustavoflor.zarco.entity.Line;
import com.github.gustavoflor.zarco.exception.LineNameAlreadyInUseException;
import com.github.gustavoflor.zarco.repository.LineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineServiceImpl implements LineService {
    private final LineRepository lineRepository;

    @Transactional
    public Line create(final CreateLineDTO dto) {
        final Line line = Line.of(dto);
        if (lineRepository.existsByName(line.getName())) {
            throw new LineNameAlreadyInUseException();
        }
        return lineRepository.save(line);
    }

    @Transactional(readOnly = true)
    public List<Line> findAll() {
        return lineRepository.findAll();
    }

    @Transactional
    public void deleteById(final Long id) {
        if (lineRepository.existsById(id)) {
            lineRepository.deleteById(id);
        }
    }
}
