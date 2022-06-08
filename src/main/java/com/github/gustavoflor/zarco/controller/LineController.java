package com.github.gustavoflor.zarco.controller;

import com.github.gustavoflor.zarco.dto.CreateLineDTO;
import com.github.gustavoflor.zarco.dto.LineDTO;
import com.github.gustavoflor.zarco.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lines")
@RequiredArgsConstructor
public class LineController {
    private final LineService lineService;

    @CacheEvict(cacheNames = "lines", allEntries = true)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LineDTO create(@Valid @RequestBody final CreateLineDTO dto) {
        return LineDTO.of(lineService.create(dto));
    }

    @Cacheable(cacheNames = "lines")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LineDTO> findAll() {
        return lineService.findAll()
            .stream()
            .map(LineDTO::of)
            .toList();
    }

    @CacheEvict(cacheNames = "lines", allEntries = true)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable final Long id) {
        lineService.deleteById(id);
    }
}
