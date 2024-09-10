package com.github.gustavoflor.zarco.input.http.v1.dto.response

data class ErrorData(
    val code: Code,
    val message: String
) {
    enum class Code {
        RESOURCE_NOT_FOUND
    }
}
