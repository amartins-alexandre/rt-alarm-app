package com.coderzen.rt.feature.alarmClock.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Treatment(
    val person: Person,
    val treatment: String,
    val startDate: Long,
    val status: Boolean,
    @PrimaryKey val id: Int? = null
)
