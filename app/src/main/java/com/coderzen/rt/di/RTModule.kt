package com.coderzen.rt.di

import android.app.Application
import androidx.room.Room
import com.coderzen.rt.feature.alarmClock.data.repository.PersonRepositoryImpl
import com.coderzen.rt.feature.alarmClock.data.source.PersonDatabase
import com.coderzen.rt.feature.alarmClock.domain.repository.PersonRepository
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
    fun providePersonDatabase(app: Application): PersonDatabase {
        return Room.databaseBuilder(
            app,
            PersonDatabase::class.java,
            PersonDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePersonRepository(db: PersonDatabase): PersonRepository {
        return PersonRepositoryImpl(db.personDao)
    }
}