package com.coderzen.rt.feature.alarm_clock.presentation.alarms.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderzen.rt.feature.alarm_clock.domain.util.AlarmOrder
import com.coderzen.rt.feature.alarm_clock.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier,
    alarmOrder: AlarmOrder,
    onOrderChange: (AlarmOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Nome",
                selected = alarmOrder is AlarmOrder.PersonName,
                onSelect = { onOrderChange(AlarmOrder.PersonName(alarmOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Retirada",
                selected = alarmOrder is AlarmOrder.Withdraw,
                onSelect = { onOrderChange(AlarmOrder.Withdraw(alarmOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = alarmOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(alarmOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = alarmOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(alarmOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}
