package com.plcoding.cryptotracker.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class EventDto(
    val id: Int,
    val description: String,
    val title: String,
    val timestamp: String,
    val image: String? = null,
    val date: String,
    val locationline1: String,
    val locationline2: String,
    val phone: String? = null
)