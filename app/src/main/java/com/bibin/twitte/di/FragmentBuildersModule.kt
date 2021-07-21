package com.bibin.twitte.di

import com.bibin.twitte.twittemanager.presentation.TwitterFeedListFragment
import com.bibin.twitte.splash.presentation.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeTwitterFeedListFragment(): TwitterFeedListFragment

}