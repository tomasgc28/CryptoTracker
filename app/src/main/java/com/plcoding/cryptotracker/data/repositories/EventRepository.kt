package com.plcoding.cryptotracker.data.repositories

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.domain.coin.model.Event

interface EventRepository {
    suspend fun getEvents(): Result<List<Event>, NetworkError>
}