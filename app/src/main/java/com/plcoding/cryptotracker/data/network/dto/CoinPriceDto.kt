package com.plcoding.cryptotracker.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceDto(
    val priceUsd: Double,
    val time: Long
)
