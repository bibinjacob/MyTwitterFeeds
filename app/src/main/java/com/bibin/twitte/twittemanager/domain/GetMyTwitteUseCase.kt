package com.bibin.twitte.twittemanager.domain

import com.bibin.twitte.base.data.GeneralErrorHandlerImpl
import com.bibin.twitte.base.domain.entity.ResponseEntity
import com.bibin.twitte.twittemanager.data.MyTwitteRepository
import com.bibin.twitte.twittemanager.domain.entity.MyTwitteEntity
import io.reactivex.Single
import javax.inject.Inject

class GetMyTwitteUseCase @Inject constructor(
    private val myTwitteRepository: MyTwitteRepository,
    private val errorHandler: GeneralErrorHandlerImpl
) {

    fun getTwitterFeedList(): Single<ResponseEntity<MyTwitteEntity>> {
        return myTwitteRepository.getTwitterFeedList()
            .map {
                errorHandler.checkForValidationError(it)
            }.onErrorReturn {
                errorHandler.getError(it)
            }
    }
}