package com.coderzen.rt.feature.alarmClock.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coderzen.rt.feature.alarmClock.domain.model.Person
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun findAll(): Flow<List<Person>>

    @Query("SELECT * FROM person WHERE id = :id")
    suspend fun findBy(id: Int): Person?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(person: Person)

    @Delete
    suspend fun remove(person: Person)
}