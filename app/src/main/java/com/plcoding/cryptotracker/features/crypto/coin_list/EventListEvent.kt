package com.plcoding.cryptotracker.features.crypto.coin_list

import com.plcoding.cryptotracker.core.domain.util.NetworkError

sealed interface EventListEvent {
    data class Error(val error: NetworkError): EventListEvent
}