package com.plcoding.cryptotracker.features.crypto.coin_list

import androidx.compose.runtime.Immutable
import com.plcoding.cryptotracker.features.crypto.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
