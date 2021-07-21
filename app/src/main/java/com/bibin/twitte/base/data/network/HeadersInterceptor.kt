package com.bibin.twitte.base.data.network

import com.bibin.twitte.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        proceed(
            request()
                .newBuilder()
                 .addHeader(
                     "Authorization",
                     BuildConfig.AUTHORIZATION_KEY
                 )
                 .addHeader("Content-Type", "application/json")
                .build()
        )
    }
}

