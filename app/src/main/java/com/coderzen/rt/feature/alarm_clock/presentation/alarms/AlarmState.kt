package com.coderzen.rt.feature.alarm_clock.presentation.alarms

import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.util.AlarmOrder
import com.coderzen.rt.feature.alarm_clock.domain.util.OrderType

data class AlarmState(
    val alarms: List<Alarm> = emptyList(),
    val alarmOrder: AlarmOrder = AlarmOrder.Withdraw(OrderType.Ascending),
    val isOrderSectionVisible: Boolean = false
)