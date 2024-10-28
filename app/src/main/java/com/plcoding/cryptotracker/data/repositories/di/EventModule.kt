package com.plcoding.cryptotracker.data.repositories.di

import com.plcoding.cryptotracker.data.repositories.EventRepositoryImpl
import com.plcoding.cryptotracker.data.repositories.EventRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EventModule {

  @Binds
  abstract fun bindCoinsRemoteSource(
    impl: EventRepositoryImpl,
  ): EventRepository
}