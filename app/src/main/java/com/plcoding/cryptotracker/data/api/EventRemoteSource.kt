package com.plcoding.cryptotracker.data.api

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Event

interface EventRemoteSource {
    suspend fun getEvent(): Result<List<Event>, NetworkError>

}