package com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.request

import jakarta.validation.constraints.NotBlank

data class CreateLineSchema(@NotBlank val name: String)