package com.example.theweather.di

import com.example.theweather.data.repository.WeatherRepositoryImpl
import com.example.theweather.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindRepository(weatherRepository: WeatherRepositoryImpl):WeatherRepository

}