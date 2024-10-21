package com.plcoding.cryptotracker.data.repositories

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Coin
import com.plcoding.cryptotracker.domain.coin.model.CoinPrice
import java.time.ZonedDateTime

interface CoinsRepository {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>

    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}