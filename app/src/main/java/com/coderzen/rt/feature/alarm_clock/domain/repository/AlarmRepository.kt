package com.coderzen.rt.feature.alarm_clock.domain.repository

import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {

    fun getAll(): Flow<List<Alarm>>

    suspend fun getBy(id: Int): Alarm?

    suspend fun save(alarm: Alarm)

    suspend fun remove(alarm: Alarm)
}