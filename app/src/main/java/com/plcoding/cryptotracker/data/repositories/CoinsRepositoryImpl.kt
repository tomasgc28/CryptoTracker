package com.plcoding.cryptotracker.data.repositories

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Coin
import com.plcoding.cryptotracker.domain.coin.model.CoinPrice
import com.plcoding.cryptotracker.data.api.CoinsRemoteSource
import java.time.ZonedDateTime
import javax.inject.Inject


class CoinsRepositoryImpl @Inject constructor(
    private val coinsRemoteSource: CoinsRemoteSource
): CoinsRepository {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return coinsRemoteSource.getCoins()
    }

    override suspend fun getCoinDetail(coinId: String): Result<Coin, NetworkError> {
        return coinsRemoteSource.getCoinDetail(coinId)
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        return coinsRemoteSource.getCoinHistory(
            coinId, start, end
        )
    }
}