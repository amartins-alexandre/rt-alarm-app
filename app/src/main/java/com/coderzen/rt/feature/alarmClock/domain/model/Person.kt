package com.coderzen.rt.feature.alarmClock.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    val name: String,
    val birthday: Long,
    val treatment: String,
    @PrimaryKey val id: Int? = null
)
