package com.plcoding.cryptotracker.domain.coin.di

import com.plcoding.cryptotracker.domain.coin.usecases.GetCoinHistoryUseCase
import com.plcoding.cryptotracker.domain.coin.usecases.GetCoinsUseCase
import com.plcoding.cryptotracker.domain.coin.usecases.impl.GetCoinHistoryUseCaseImpl
import com.plcoding.cryptotracker.domain.coin.usecases.impl.GetCoinsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CoinsUseCaseModule {

    @Binds
    abstract fun bindGetCoinsUseCase(
        impl: GetCoinsUseCaseImpl
    ): GetCoinsUseCase

    @Binds
    abstract fun bindGetCoinHistoryUseCase(
        impl: GetCoinHistoryUseCaseImpl
    ): GetCoinHistoryUseCase
}