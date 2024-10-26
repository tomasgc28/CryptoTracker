package com.plcoding.cryptotracker.domain.coin.usecases

import com.plcoding.cryptotracker.domain.util.NetworkError
import com.plcoding.cryptotracker.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Coin

interface GetCoinsUseCase {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}