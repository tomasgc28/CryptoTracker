package com.plcoding.cryptotracker.data.api.di

import com.plcoding.cryptotracker.data.api.EventRemoteSource
import com.plcoding.cryptotracker.data.api.CoinsRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

  @Binds
  abstract fun bindCoinsService(impl: CoinsRemoteSourceImpl): EventRemoteSource

}