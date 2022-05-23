package com.github.gustavoflor.zarco.dto;

import javax.validation.constraints.NotBlank;

public record CreateLineDTO(@NotBlank String name) {
}
