package com.plcoding.cryptotracker.domain.util

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.toLocalDateTimeString(pattern: String = "yyyy-MM-dd HH:mm:ss"): String {
    return ZonedDateTime.parse(this)
        .withZoneSameInstant(ZoneId.systemDefault())
        .format(DateTimeFormatter.ofPattern(pattern))
}

fun String.toLocalDate(): LocalDate? {
    val localDate = Instant
        .parse(this)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()

    return localDate
}