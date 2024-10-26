package com.plcoding.cryptotracker.features.crypto.coin_detail

import com.plcoding.cryptotracker.features.crypto.models.CoinUi

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinUi? = null,
)
