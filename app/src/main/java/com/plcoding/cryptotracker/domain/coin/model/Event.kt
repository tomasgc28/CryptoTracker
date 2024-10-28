package com.plcoding.cryptotracker.domain.coin.model

data class Event(
    val id: Int,
    val description: String,
    val title: String,
    val timestamp: String,
    val image: String? = null,
    val date: String,
    val locationLine1: String,
    val locationLine2: String,
    val phone: String? = null
)
