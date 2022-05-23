package com.github.gustavoflor.zarco.controller;

import com.github.gustavoflor.zarco.entity.Line;
import com.github.gustavoflor.zarco.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lines")
@RequiredArgsConstructor
public class LineController {
    private final LineService lineService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Line> findAll() {
        return lineService.findAll();
    }
}
