package com.bibin.twitte.base.domain.entity

import androidx.annotation.Keep

@Keep
data class ErrorDataEntity(
    val errors: List<Errors>? = listOf()
)

data class Errors(
    val code: Int? = 0,
    val message: String? = ""
)