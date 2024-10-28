package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.BuildConfig
const val BASE_URL = "https://raw.githubusercontent.com/phunware-services/dev-interview-homework/master/"
fun constructUrl(url: String): String {
    return when {
        url.contains(BASE_URL) -> url
        url.startsWith("/") -> BASE_URL + url.drop(1)
        else -> BASE_URL + url
    }
}