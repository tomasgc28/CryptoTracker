package com.plcoding.cryptotracker.domain.coin.usecases.impl

import com.plcoding.cryptotracker.domain.util.NetworkError
import com.plcoding.cryptotracker.domain.util.Result
import com.plcoding.cryptotracker.data.repositories.CoinsRepository
import com.plcoding.cryptotracker.domain.coin.model.Coin
import com.plcoding.cryptotracker.domain.coin.usecases.GetCoinDetailUseCase
import javax.inject.Inject

class GetCoinDetailUseCaseImpl @Inject constructor(
    private val coinsRepository: CoinsRepository
) : GetCoinDetailUseCase {
    override suspend fun getCoinDetail(coinId: String): Result<Coin, NetworkError> {
        return coinsRepository.getCoinDetail(coinId)
    }
}