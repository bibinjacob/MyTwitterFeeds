package com.bibin.twitte.base.data.network.entity

data class ResponseData<T>(
    var response: T? = null,
    val message: String? = "",
    val status: String? = "",
    val statusCode: Int? = 0,
    val errors: List<String>?=null
)