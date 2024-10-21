package com.plcoding.cryptotracker.features.crypto.coin_list

import com.plcoding.cryptotracker.features.crypto.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}