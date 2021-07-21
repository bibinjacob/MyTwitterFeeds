package com.bibin.twitte.di

import android.app.Application
import com.bibin.twitte.base.presentation.MyApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class, MainActivityModule::class,
        RepositoryModule::class, UseCaseRepository::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


    fun inject(app: MyApp)
}