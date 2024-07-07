package com.coderzen.rt.feature.alarm_clock.domain.use_case

import com.coderzen.rt.feature.alarm_clock.domain.exception.InvalidAlarmException
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.repository.AlarmRepository

class UpsertAlarm(
    private val repository: AlarmRepository
) {

    @Throws(InvalidAlarmException::class)
    suspend operator fun invoke(alarm: Alarm) {
        if (alarm.personName.isBlank()) {
            throw InvalidAlarmException("The person name of the alarm can't br empty")
        }

        repository.save(alarm)
    }
}