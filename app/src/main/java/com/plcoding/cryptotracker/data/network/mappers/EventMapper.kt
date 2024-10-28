package com.plcoding.cryptotracker.data.network.mappers

import com.plcoding.cryptotracker.data.network.dto.EventDto
import com.plcoding.cryptotracker.domain.coin.model.Event

fun EventDto.toEvent(): Event {
    return Event(
        id = id,
        description = description,
        title = title,
        timestamp = timestamp,
        image = image,
        date = date,
        locationLine1 = locationline1,
        locationLine2 = locationline2,
        phone = phone
    )
}
