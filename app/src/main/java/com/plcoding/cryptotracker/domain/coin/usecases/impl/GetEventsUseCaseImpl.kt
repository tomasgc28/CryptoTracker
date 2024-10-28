package com.plcoding.cryptotracker.domain.coin.usecases.impl

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.data.repositories.EventRepository
import com.plcoding.cryptotracker.domain.coin.model.Event
import com.plcoding.cryptotracker.domain.coin.usecases.GetEventUseCase
import javax.inject.Inject

class GetEventsUseCaseImpl @Inject constructor(
    private val eventRepository: EventRepository
) : GetEventUseCase {
    override suspend fun getEvents(): Result<List<Event>, NetworkError> {
        return eventRepository.getEvents()
    }
}