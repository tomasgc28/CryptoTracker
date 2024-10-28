package com.plcoding.cryptotracker.data.repositories

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.data.api.EventRemoteSource
import com.plcoding.cryptotracker.domain.coin.model.Event
import javax.inject.Inject


class EventRepositoryImpl @Inject constructor(
    private val eventRemoteSource: EventRemoteSource
): EventRepository {

    override suspend fun getEvents(): Result<List<Event>, NetworkError> {
       return eventRemoteSource.getEvent()
    }
}