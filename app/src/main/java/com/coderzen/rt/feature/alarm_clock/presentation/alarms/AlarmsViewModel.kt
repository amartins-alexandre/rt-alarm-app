package com.coderzen.rt.feature.alarm_clock.presentation.alarms

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.use_case.AlarmUseCases
import com.coderzen.rt.feature.alarm_clock.domain.util.AlarmOrder
import com.coderzen.rt.feature.alarm_clock.domain.util.OrderType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmsViewModel @Inject constructor(
    private val alarmUseCases: AlarmUseCases
) : ViewModel() {
    private val _state = mutableStateOf(AlarmState())
    val state: State<AlarmState> = _state

    private var recentlyDeletedAlarm: Alarm? = null
    private var getAlarmsJob: Job? = null

    init {
        getAlarms(AlarmOrder.Withdraw(OrderType.Ascending))
    }

    fun onEvent(event: AlarmsEvent) {
        when (event) {
            is AlarmsEvent.Order -> {
                if (state.value.alarmOrder::class == event.alarmOrder::class &&
                    state.value.alarmOrder.orderType == event.alarmOrder.orderType
                ) {
                    return
                }
                getAlarms(event.alarmOrder)
            }

            is AlarmsEvent.DeleteAlarm -> {
                viewModelScope.launch {
                    alarmUseCases.deleteAlarm(event.alarm)
                    recentlyDeletedAlarm = event.alarm
                }
            }

            is AlarmsEvent.RestoreAlarm -> {
                viewModelScope.launch {
                    alarmUseCases.upsertAlarm(recentlyDeletedAlarm ?: return@launch)
                    recentlyDeletedAlarm = null
                }
            }

            is AlarmsEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun getAlarms(alarmOrder: AlarmOrder) {
        getAlarmsJob?.cancel()
        getAlarmsJob = alarmUseCases.getAlarms(alarmOrder)
            .onEach { alarms ->
                _state.value = state.value.copy(
                    alarms = alarms,
                    alarmOrder = alarmOrder
                )
            }.launchIn(viewModelScope)
    }
}