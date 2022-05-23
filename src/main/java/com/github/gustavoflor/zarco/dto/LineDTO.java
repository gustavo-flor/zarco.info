package com.github.gustavoflor.zarco.dto;

import com.github.gustavoflor.zarco.entity.Line;

public record LineDTO(Long number, String name) {
    public static LineDTO of(final Line line) {
        return new LineDTO(line.getId(), line.getName());
    }
}
