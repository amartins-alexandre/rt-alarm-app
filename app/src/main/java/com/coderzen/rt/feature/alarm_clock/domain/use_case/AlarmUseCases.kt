package com.coderzen.rt.feature.alarm_clock.domain.use_case

data class AlarmUseCases (
    val getAlarms: GetAlarms,
    val upsertAlarm: UpsertAlarm,
    val deleteAlarm: DeleteAlarm
)