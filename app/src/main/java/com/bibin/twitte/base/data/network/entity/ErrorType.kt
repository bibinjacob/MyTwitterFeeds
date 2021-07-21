package com.bibin.twitte.base.data.network.entity

import androidx.annotation.Keep
import kotlin.reflect.KClass

@Keep
@Retention(AnnotationRetention.RUNTIME)
annotation class ErrorType(val type: KClass<*>)

@Keep
data class ErrorResponseData(
    var errors: List<Error>? = null,
    val statusCode: Int? = 0
)

data class Error(
    val code: Int = 0,
    val message: String = ""
)

