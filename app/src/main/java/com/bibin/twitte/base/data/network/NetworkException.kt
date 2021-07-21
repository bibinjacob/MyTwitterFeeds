package com.bibin.twitte.base.data.network

import androidx.annotation.Keep

@Keep
internal data class NetworkException(
    val error: Any?,
    override val message: String = "",
    val throwable: Throwable
) : RuntimeException()