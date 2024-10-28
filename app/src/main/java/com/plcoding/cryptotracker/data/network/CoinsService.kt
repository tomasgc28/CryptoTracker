package com.plcoding.cryptotracker.data.network

import com.plcoding.cryptotracker.core.data.networking.constructUrl
import com.plcoding.cryptotracker.core.data.networking.safeCall
import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.core.domain.util.map
import com.plcoding.cryptotracker.data.network.dto.EventDto
import com.plcoding.cryptotracker.data.network.mappers.toEvent
import com.plcoding.cryptotracker.domain.coin.model.Event
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import javax.inject.Inject

class CoinsService @Inject constructor(
    private val httpClient: HttpClient
) {
    suspend fun getFeed(): Result<List<Event>, NetworkError> {
        return safeCall<List<EventDto>> {
            httpClient.get(
                urlString = constructUrl("feed.json")
            )
        }.map { response ->
            response.map { it.toEvent() }
        }
    }
}