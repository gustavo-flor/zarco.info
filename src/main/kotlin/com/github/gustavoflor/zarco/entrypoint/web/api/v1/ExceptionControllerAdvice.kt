package com.github.gustavoflor.zarco.entrypoint.web.api.v1

import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.error.ErrorCode
import com.github.gustavoflor.zarco.entrypoint.web.api.v1.schema.response.error.ErrorSchema
import com.github.gustavoflor.zarco.entrypoint.web.exception.ResourceNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.sql.SQLException

@RestControllerAdvice(basePackages = ["com.github.gustavoflor.zarco.entrypoint.web.api.v1"])
class ExceptionControllerAdvice {
    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleResourceNotFoundException(e: ResourceNotFoundException) = ErrorSchema(
        code = ErrorCode.RESOURCE_NOT_FOUND,
        message = e.message
    )

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(e: Exception): ErrorSchema {
        log.error(e.message, e)
        return ErrorSchema(
            code = ErrorCode.INTERNAL_SERVER_ERROR,
            message = "Ops... something went wrong, please try again later. Check the logs to get more infos."
        )
    }
}
