package com.coderzen.rt.di

import android.app.Application
import androidx.room.Room
import com.coderzen.rt.feature.alarm_clock.data.repository.AlarmRepositoryImpl
import com.coderzen.rt.feature.alarm_clock.data.source.AlarmDatabase
import com.coderzen.rt.feature.alarm_clock.domain.repository.AlarmRepository
import com.coderzen.rt.feature.alarm_clock.domain.use_case.AlarmUseCases
import com.coderzen.rt.feature.alarm_clock.domain.use_case.DeleteAlarm
import com.coderzen.rt.feature.alarm_clock.domain.use_case.GetAlarms
import com.coderzen.rt.feature.alarm_clock.domain.use_case.UpsertAlarm
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RTModule {

    @Provides
    @Singleton
    fun provideAlarmDatabase(app: Application): AlarmDatabase {
        return Room.databaseBuilder(
            app,
            AlarmDatabase::class.java,
            AlarmDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideAlarmRepository(db: AlarmDatabase): AlarmRepository {
        return AlarmRepositoryImpl(db.alarmDao)
    }

    @Provides
    @Singleton
    fun provideAlarmUseCases(repository: AlarmRepository): AlarmUseCases {
        return AlarmUseCases(
            getAlarms = GetAlarms(repository),
            deleteAlarm = DeleteAlarm(repository),
            upsertAlarm = UpsertAlarm(repository)
        )
    }
}