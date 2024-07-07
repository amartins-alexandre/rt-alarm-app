package com.coderzen.rt.feature.alarm_clock.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm


@Database(entities = [Alarm::class], version = 1)
abstract class AlarmDatabase : RoomDatabase() {

    abstract val alarmDao: AlarmDao

    companion object {
        const val DATABASE_NAME = "alarm_clock"
    }
}