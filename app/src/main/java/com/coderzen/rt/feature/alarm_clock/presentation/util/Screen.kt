package com.coderzen.rt.feature.alarm_clock.presentation.util

sealed class Screen(val route: String) {
    data object AlarmScreen : Screen("alarm_screen")
    data object UpsertAlarmScreen : Screen("upsert_alarm_screen")
}