package com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.request

import jakarta.validation.constraints.NotBlank

data class CreateLineRequest(@NotBlank val name: String)
