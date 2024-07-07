package com.coderzen.rt.feature.alarm_clock.domain.use_case

import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.repository.AlarmRepository

class DeleteAlarm(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke(alarm: Alarm) {
        repository.remove(alarm)
    }
}