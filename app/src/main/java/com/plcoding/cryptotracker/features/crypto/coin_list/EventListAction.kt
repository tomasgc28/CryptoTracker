package com.plcoding.cryptotracker.features.crypto.coin_list

import com.plcoding.cryptotracker.domain.coin.model.Event

sealed interface EventListAction {
    data class OnEventClick(val event: Event): EventListAction
}