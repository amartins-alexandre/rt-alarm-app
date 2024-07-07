package com.coderzen.rt.feature.alarm_clock.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Query("SELECT * FROM alarm")
    fun findAll(): Flow<List<Alarm>>

    @Query("SELECT * FROM alarm WHERE id = :id")
    suspend fun findBy(id: Int): Alarm?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(alarm: Alarm)

    @Delete
    suspend fun delete(alarm: Alarm)
}