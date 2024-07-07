package com.coderzen.rt.feature.alarm_clock.domain.util

sealed class OrderType {
    data object Ascending: OrderType()
    data object Descending: OrderType()
}
