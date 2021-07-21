package com.bibin.twitte.twittemanager.data

import com.bibin.twitte.base.data.network.RepoService
import com.bibin.twitte.base.data.network.entity.mapToTwitteResponseEntity
import com.bibin.twitte.base.domain.entity.ResponseEntity
import com.bibin.twitte.twittemanager.domain.entity.MyTwitteEntity
import io.reactivex.Single
import javax.inject.Inject

class MyTwitteRepository @Inject constructor(private var repoService: RepoService) {

    fun getTwitterFeedList(): Single<ResponseEntity<MyTwitteEntity>> {

        return repoService.getTwitterFeedList().map {
            it.mapToTwitteResponseEntity()
        }
    }
}