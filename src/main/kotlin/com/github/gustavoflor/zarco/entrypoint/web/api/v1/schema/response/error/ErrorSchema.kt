package com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.error

data class ErrorSchema(
    val code: ErrorCode,
    val message: String
)
