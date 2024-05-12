package com.github.gustavoflor.zarco.entrypoint.web.api.v1.dto.response.error

data class ErrorResponse(
    val code: ErrorCode,
    val message: String
)
