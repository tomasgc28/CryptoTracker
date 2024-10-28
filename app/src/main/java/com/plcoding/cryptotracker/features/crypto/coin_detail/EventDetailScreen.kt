package com.plcoding.cryptotracker.features.crypto.coin_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.plcoding.cryptotracker.domain.coin.model.Event

@Composable
fun EventDetailsScreen(modifier: Modifier = Modifier, event: Event) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = event.title, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        event.image?.let {
            AsyncImage(
                model = it, contentDescription = null,
                contentScale = ContentScale.Crop, modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        Text(text = "Description: ${event.description}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Date: ${event.date}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Location: ${event.locationLine1}, ${event.locationLine2}")
        event.phone?.let {
            Text(text = "Phone: $it")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EventDetailsScreenPreview() {
    val sampleEvent = Event(
        id = 1,
        title = "Sample Event",
        description = "This is a description of the sample event.",
        date = "2024-10-28",
        locationLine1 = "123 Main St",
        locationLine2 = "City, State, ZIP",
        phone = "123-456-7890",
        image = "https://example.com/sample-image.jpg",
        timestamp = ""
    )

    EventDetailsScreen(event = sampleEvent)
}
