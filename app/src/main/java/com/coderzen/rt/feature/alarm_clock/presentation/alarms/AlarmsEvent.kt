package com.coderzen.rt.feature.alarm_clock.presentation.alarms

import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.util.AlarmOrder

sealed class AlarmsEvent {
    data class Order(val alarmOrder: AlarmOrder) : AlarmsEvent()
    data class DeleteAlarm(val alarm: Alarm) : AlarmsEvent()
    data object RestoreAlarm : AlarmsEvent()
    data object ToggleOrderSection : AlarmsEvent()
}