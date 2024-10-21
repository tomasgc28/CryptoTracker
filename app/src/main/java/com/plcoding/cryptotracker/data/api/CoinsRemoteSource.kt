package com.plcoding.cryptotracker.data.api

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Coin
import com.plcoding.cryptotracker.domain.coin.model.CoinPrice
import java.time.ZonedDateTime

interface CoinsRemoteSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>

    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}