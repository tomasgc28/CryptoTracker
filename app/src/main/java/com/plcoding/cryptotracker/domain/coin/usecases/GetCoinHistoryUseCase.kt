package com.plcoding.cryptotracker.domain.coin.usecases

import com.plcoding.cryptotracker.domain.util.NetworkError
import com.plcoding.cryptotracker.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.CoinPrice
import java.time.ZonedDateTime

interface GetCoinHistoryUseCase {

    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}