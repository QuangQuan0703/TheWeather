package com.example.theweather.di

import com.example.theweather.data.loaction.DefaultLocation
import com.example.theweather.domain.location.LocationCheck
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton
@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocation(location: DefaultLocation): LocationCheck
}