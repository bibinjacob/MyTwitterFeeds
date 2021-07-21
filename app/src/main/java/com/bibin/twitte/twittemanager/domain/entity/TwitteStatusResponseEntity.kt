package com.bibin.twitte.twittemanager.domain.entity

data class User(
    val friendsCount: Int? = null,
    val profileImageUrlHttps: String? = null,
    val description: String? = null,
    val id: Long? = null
)

data class MyTwitteEntity(
    val createdAt: String? = null,
    val fullText: String? = null,
    val id: Long? = null,
    val user: User? = null
)


