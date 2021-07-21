package com.bibin.twitte.di

import com.bibin.twitte.base.data.GeneralErrorHandlerImpl
import com.bibin.twitte.base.domain.ErrorHandler
import com.bibin.twitte.twittemanager.data.MyTwitteRepository
import com.bibin.twitte.twittemanager.domain.GetMyTwitteUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseRepository {

    @Singleton
    @Provides
    fun provideGetMyTwitteUseCase(myTwitteRepository: MyTwitteRepository,errorHandler: GeneralErrorHandlerImpl): GetMyTwitteUseCase {
        return GetMyTwitteUseCase(myTwitteRepository,errorHandler)
    }
}