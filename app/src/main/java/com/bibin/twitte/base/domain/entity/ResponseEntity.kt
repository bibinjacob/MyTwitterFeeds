package com.bibin.twitte.base.domain.entity

data class ResponseEntity<T>(
    val response: List<T>? = null,
    val errors: List<Errors>? = null,
    val statusCode: Int = 200,
    var errorEntity: ErrorEntity? = ErrorEntity.ApiError.Unknown
)