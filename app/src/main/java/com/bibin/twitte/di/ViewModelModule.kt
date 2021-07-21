package com.bibin.twitte.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bibin.twitte.twittemanager.presentation.TwitterFeedListViewModel
import com.bibin.twitte.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TwitterFeedListViewModel::class)
    abstract fun bindTwitterFeedListViewModel(twitterFeedListViewModel: TwitterFeedListViewModel): ViewModel
}