package com.plcoding.cryptotracker.domain.coin.usecases.impl

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.CoinPrice
import com.plcoding.cryptotracker.data.repositories.CoinsRepository
import com.plcoding.cryptotracker.domain.coin.usecases.GetCoinHistoryUseCase
import java.time.ZonedDateTime
import javax.inject.Inject


class GetCoinHistoryUseCaseImpl @Inject constructor(
    private val coinsRepository: CoinsRepository
) : GetCoinHistoryUseCase {
    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        return coinsRepository.getCoinHistory(coinId, start, end)
    }
}