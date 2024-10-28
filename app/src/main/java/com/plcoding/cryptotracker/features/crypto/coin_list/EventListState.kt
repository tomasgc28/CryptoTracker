package com.plcoding.cryptotracker.features.crypto.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.domain.coin.model.Event

@Immutable
data class EventListState(
    val isLoading: Boolean = false,
    val event: List<Event> = emptyList(),
    val selectedEvent: Event? = null
)
