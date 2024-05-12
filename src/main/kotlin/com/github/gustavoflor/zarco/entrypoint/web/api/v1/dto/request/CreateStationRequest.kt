package com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.request

import jakarta.validation.constraints.NotBlank

data class CreateStationRequest(@NotBlank val name: String)
