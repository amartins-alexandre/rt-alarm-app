package com.coderzen.rt.feature.alarmClock.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coderzen.rt.ui.theme.LightGreen
import com.coderzen.rt.ui.theme.RedOrange

@Entity
data class GraphicSchedule(
    val person: Person,
    val treatment: Treatment,
    val graphic: String,
    val withdrawAt: Long,
    val status: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val statusColor = listOf(LightGreen, RedOrange)
    }
}
