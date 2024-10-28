package com.plcoding.cryptotracker.domain.coin.di

import com.plcoding.cryptotracker.domain.coin.usecases.GetEventUseCase
import com.plcoding.cryptotracker.domain.coin.usecases.impl.GetEventsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class EventUseCaseModule {

    @Binds
    abstract fun bindGetEventUseCase(
        impl: GetEventsUseCaseImpl
    ): GetEventUseCase

}