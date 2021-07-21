package com.bibin.twitte.base.presentation

import com.bibin.twitte.base.domain.entity.ErrorEntity

data class Response (
    val message: Int? = 0,
    val status: String? = "",
    val statusCode: Int? = 0,
    var errorEntity: ErrorEntity? = ErrorEntity.ApiError.Unknown,
    val success: Boolean = false
)