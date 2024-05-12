package com.github.gustavoflor.zarco.entrypoint.web.exception

class ResourceNotFoundException(override val message: String) : RuntimeException(message) {
}