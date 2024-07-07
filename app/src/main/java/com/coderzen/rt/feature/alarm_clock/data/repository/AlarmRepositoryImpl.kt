package com.coderzen.rt.feature.alarm_clock.data.repository

import com.coderzen.rt.feature.alarm_clock.data.source.AlarmDao
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow

class AlarmRepositoryImpl(
    private val dao: AlarmDao
) : AlarmRepository {

    override fun getAll(): Flow<List<Alarm>> {
        return dao.findAll()
    }

    override suspend fun getBy(id: Int): Alarm? {
        return dao.findBy(id)
    }

    override suspend fun save(alarm: Alarm) {
        dao.save(alarm)
    }

    override suspend fun remove(alarm: Alarm) {
        dao.delete(alarm)
    }
}