package com.coderzen.rt.feature.alarmClock.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coderzen.rt.feature.alarmClock.domain.model.Person


@Database(entities = [Person::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {

    abstract val personDao: PersonDao

    companion object {
        const val DATABASE_NAME = "person_db"
    }
}