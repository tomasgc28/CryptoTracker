package com.plcoding.cryptotracker.features.crypto.coin_detail

import com.plcoding.cryptotracker.domain.util.NetworkError

sealed interface CoinDetailEvent {
    data class Error(val error: NetworkError): CoinDetailEvent
}