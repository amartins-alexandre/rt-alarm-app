package com.coderzen.rt.feature.alarm_clock.domain.use_case

import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.feature.alarm_clock.domain.repository.AlarmRepository
import com.coderzen.rt.feature.alarm_clock.domain.util.AlarmOrder
import com.coderzen.rt.feature.alarm_clock.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAlarms(
    private val repository: AlarmRepository
) {
    operator fun invoke(
        alarmOrder: AlarmOrder = AlarmOrder.Withdraw(OrderType.Ascending)
    ): Flow<List<Alarm>> {
        return repository.getAll().map { alarms ->
            when (alarmOrder.orderType) {
                is OrderType.Ascending -> {
                    when (alarmOrder) {
                        is AlarmOrder.PersonName -> alarms.sortedBy { it.personName.lowercase() }
                        is AlarmOrder.Withdraw -> alarms.sortedBy { it.withdraw }
                    }
                }

                else -> {
                    when (alarmOrder) {
                        is AlarmOrder.PersonName -> alarms.sortedByDescending {
                            it.personName.lowercase()
                        }

                        is AlarmOrder.Withdraw -> alarms.sortedByDescending {
                            it.withdraw
                        }
                    }
                }
            }
        }
    }
}