package com.coderzen.rt.feature.alarm_clock.presentation.alarms.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coderzen.rt.feature.alarm_clock.domain.model.Alarm
import com.coderzen.rt.ui.theme.CoderZenTheme
import com.coderzen.rt.ui.theme.darkGray
import com.coderzen.rt.ui.theme.gray
import com.coderzen.rt.ui.theme.orange
import com.coderzen.rt.ui.theme.white
import java.time.OffsetDateTime

@Composable
fun AlarmItem(
    alarm: Alarm,
    modifier: Modifier = Modifier,
    circleRadius: Float = 230f,
    cutCornerSize: Dp = 30.dp,
    onDeleteClick: () -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = darkGray,
        ),
        modifier = modifier.size(width = 240.dp, height = 350.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = alarm.personName,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 1
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Tratamento:",
                    fontSize = 14.sp,
                    color = white
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = alarm.treatment,
                    fontSize = 14.sp,
                    color = white
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Gráfico:",
                    fontSize = 14.sp,
                    color = white
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = alarm.graphic,
                    fontSize = 14.sp,
                    color = white
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Local:",
                    fontSize = 14.sp,
                    color = white
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = alarm.local,
                    fontSize = 14.sp,
                    color = white
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            CustomCircularProgressIndicator(
                modifier = Modifier.size(250.dp),
                initialValue = 50,
                primaryColor = orange,
                secondaryColor = gray,
                circleRadius = circleRadius,
                onPositionChange = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AlarmItemPreview() {
    CoderZenTheme {
        AlarmItem(
            alarm = Alarm(
                id = 1,
                personName = "Alexandre Araujo Martins",
                treatment = "7 Chakras",
                graphic = "Corpo Humano",
                withdraw = OffsetDateTime.now(),
                local = "Gaya-2A",
                status = false,
            ),
            onDeleteClick = { TODO() }
        )
    }
}