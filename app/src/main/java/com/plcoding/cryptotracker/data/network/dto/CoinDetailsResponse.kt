package com.plcoding.cryptotracker.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinDetailsResponse(
    val data: CoinDto
)