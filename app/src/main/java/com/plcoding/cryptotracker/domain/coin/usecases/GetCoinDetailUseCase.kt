package com.plcoding.cryptotracker.domain.coin.usecases

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Coin

interface GetCoinDetailUseCase {
    suspend fun getCoinDetail(coinId: String): Result<Coin, NetworkError>
}