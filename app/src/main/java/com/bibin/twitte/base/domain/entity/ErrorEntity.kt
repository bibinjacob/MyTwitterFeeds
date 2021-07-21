package com.bibin.twitte.base.domain.entity

import androidx.annotation.Keep

@Keep
sealed class ErrorEntity {
    sealed class ApiError : ErrorEntity() {

        object NoInternet : ApiError()

        object TimeOutError : ApiError()

        object ValidationError : ApiError()

        object UnknownHttpError : ApiError()

        object UnknownNetworkError : ApiError()

        object Unknown : ApiError()
    }
}