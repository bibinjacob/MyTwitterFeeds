package com.bibin.twitte.base.data.network

import com.bibin.twitte.base.data.network.entity.ErrorResponseData
import com.bibin.twitte.base.data.network.entity.ErrorType
import com.bibin.twitte.twittemanager.data.entity.MyTwitteData
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Retrofit class for apis
 * */
interface RepoService {

    @GET("1.1/lists/statuses.json?list_id=871746761387323394&tweet_mode=extended&include_entities=1&count=10")
    @ErrorType(ErrorResponseData::class)
    fun getTwitterFeedList(): Single<List<MyTwitteData>>
}