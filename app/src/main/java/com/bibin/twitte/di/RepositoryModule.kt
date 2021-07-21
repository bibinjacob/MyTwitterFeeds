package com.bibin.twitte.di

import com.bibin.twitte.base.data.network.RepoService
import com.bibin.twitte.twittemanager.data.MyTwitteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMyTwitteRepository(repoService: RepoService): MyTwitteRepository {
        return MyTwitteRepository(repoService)
    }
}