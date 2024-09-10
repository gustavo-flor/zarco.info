package com.github.gustavoflor.zarco.input.http.v1

import com.github.gustavoflor.zarco.input.http.v1.dto.response.ErrorData
import com.github.gustavoflor.zarco.input.http.v1.exception.ResourceNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(e: ResourceNotFoundException) = ErrorData(
        code = ErrorData.Code.RESOURCE_NOT_FOUND,
        message = e.message
    )
}
