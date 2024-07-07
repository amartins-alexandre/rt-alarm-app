package com.coderzen.rt.feature.alarm_clock.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alarm(
    val personName: String,
    val treatment: String,
    val graphic: String,
    val local: String,
    val withdraw: Long,
    val status: Boolean,
    @PrimaryKey val id: Int? = null
)
