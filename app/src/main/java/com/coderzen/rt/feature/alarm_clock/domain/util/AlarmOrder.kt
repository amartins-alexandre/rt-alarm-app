package com.coderzen.rt.feature.alarm_clock.domain.util

sealed class AlarmOrder(val orderType: OrderType) {
    class PersonName(orderType: OrderType): AlarmOrder(orderType)
    class Withdraw(orderType: OrderType): AlarmOrder(orderType)

    fun copy(orderType: OrderType): AlarmOrder {
        return when(this) {
            is PersonName -> PersonName(orderType)
            is Withdraw -> Withdraw(orderType)
        }
    }
}