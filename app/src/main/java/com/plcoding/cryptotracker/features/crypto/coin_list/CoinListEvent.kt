package com.plcoding.cryptotracker.features.crypto.coin_list

import com.plcoding.cryptotracker.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}