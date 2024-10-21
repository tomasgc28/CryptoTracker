package com.plcoding.cryptotracker.domain.coin.usecases.impl

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Coin
import com.plcoding.cryptotracker.data.repositories.CoinsRepository
import com.plcoding.cryptotracker.domain.coin.usecases.GetCoinsUseCase
import javax.inject.Inject

class GetCoinsUseCaseImpl @Inject constructor(
    private val coinsRepository: CoinsRepository
) : GetCoinsUseCase {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return coinsRepository.getCoins()
    }
}