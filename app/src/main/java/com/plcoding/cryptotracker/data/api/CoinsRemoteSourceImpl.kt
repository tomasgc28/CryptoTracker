package com.plcoding.cryptotracker.data.api

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.data.network.CoinsService
import com.plcoding.cryptotracker.domain.coin.model.Event
import javax.inject.Inject

class CoinsRemoteSourceImpl @Inject constructor(
    private val coinsService: CoinsService
) : EventRemoteSource {

    override suspend fun getEvent(): Result<List<Event>, NetworkError> {
        return coinsService.getFeed()
    }
}