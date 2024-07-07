package com.coderzen.rt.feature.alarm_clock.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.util.DateConverters


@Database(entities = [Alarm::class], version = 3, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class AlarmDatabase : RoomDatabase() {

    abstract val alarmDao: AlarmDao

    companion object {
        const val DATABASE_NAME = "alarm_clock"
    }
}