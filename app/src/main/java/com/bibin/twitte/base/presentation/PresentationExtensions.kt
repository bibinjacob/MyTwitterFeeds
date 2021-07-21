package com.bibin.twitte.base.presentation

import com.bibin.twitte.R
import com.bibin.twitte.base.domain.entity.ErrorEntity
import com.bibin.twitte.base.domain.entity.ResponseEntity

fun <T> ResponseEntity<T>.entityToPresentation(): Response {
    return Response(
        statusCode = this.statusCode,
        message = getMessage(),
        errorEntity = this.errorEntity,
        success = this.statusCode == 200//STATUS_CODE_200
    )
}

private fun <T> ResponseEntity<T>.getMessage(): Int {
    return when (errorEntity) {
        ErrorEntity.ApiError.UnknownNetworkError -> {
            R.string.error_internal_error_occurred
        }
        ErrorEntity.ApiError.NoInternet, ErrorEntity.ApiError.TimeOutError -> {
            R.string.no_internet
        }
        else -> {
            R.string.unknown_error
        }
    }
}