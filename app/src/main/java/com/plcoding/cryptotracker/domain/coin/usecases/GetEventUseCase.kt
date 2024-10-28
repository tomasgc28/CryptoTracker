package com.plcoding.cryptotracker.domain.coin.usecases

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Event

interface GetEventUseCase {
    suspend fun getEvents(): Result<List<Event>, NetworkError>
}