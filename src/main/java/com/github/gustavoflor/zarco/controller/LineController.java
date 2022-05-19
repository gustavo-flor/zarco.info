package com.github.gustavoflor.zarco.controller;

import com.github.gustavoflor.zarco.service.LineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lines")
@RequiredArgsConstructor
public class LineController {
    private final LineService lineService;
}
