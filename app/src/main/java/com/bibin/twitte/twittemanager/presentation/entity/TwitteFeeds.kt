package com.bibin.twitte.twittemanager.presentation.entity

data class User(
    val friendsCount: Int? = null,
    val profileImageUrlHttps: String? = null,
    val description: String? = null,
    val id: Long? = null
)

data class MyTwitte(
    val createdAt: String? = "",
    val fullText: String? = "",
    val id: Long? = null,
    val user: User? = null
)


