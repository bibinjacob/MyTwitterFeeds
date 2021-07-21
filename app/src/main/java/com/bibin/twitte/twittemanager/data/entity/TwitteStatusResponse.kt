package com.bibin.twitte.twittemanager.data.entity

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("friends_count")
	val friendsCount: Int? = null,

	@field:SerializedName("profile_image_url_https")
	val profileImageUrlHttps: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Long? = null
)

data class MyTwitteData(

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("full_text")
	val fullText: String? = null,

	@field:SerializedName("id")
	val id: Long? = null,

	@field:SerializedName("user")
	val user: User? = null
)


