package com.plcoding.cryptotracker.features.crypto.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.domain.coin.model.Event
import com.plcoding.cryptotracker.domain.util.toLocalDate
import java.time.Instant
import java.time.ZoneId
import java.time.temporal.TemporalQueries.localDate

@Composable
fun EventItem(
    event: Event,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Event,
            contentDescription = event.title,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = event.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Text(
                text = event.description,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = contentColor,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = event.date.toLocalDate().toString(),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = event.locationLine1,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventItemPreview() {
    val previewEvent = Event(
        id = 1,
        description = "A gathering of tech enthusiasts to discuss future trends in AI.",
        title = "Tech Meetup 2024",
        timestamp = "2024-10-28T12:00:00Z",
        image = null,
        date = "2024-10-28T12:00:00Z",
        locationLine1 = "123 Main St",
        locationLine2 = "Tech City",
        phone = "+1234567890"
    )

    EventItem(
        event = previewEvent,
        onClick = {},
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    )
}

