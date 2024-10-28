package com.plcoding.cryptotracker.features.crypto.coin_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.plcoding.cryptotracker.core.designsystem.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.domain.coin.model.Event
import com.plcoding.cryptotracker.features.crypto.coin_list.components.EventItem

@Composable
fun EventListScreen(
    state: EventListState,
    onAction: (EventListAction) -> Unit,
    modifier: Modifier = Modifier
) {
    if (state.isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(state.event) { eventUi ->
                EventItem(
                    event = eventUi,
                    onClick = {
                        onAction(EventListAction.OnEventClick(eventUi))
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                HorizontalDivider()
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    CryptoTrackerTheme {
        EventListScreen(
            state = EventListState(
                event = (1..100).map {
                    Event(
                        id = it,
                        description = "Event description $it",
                        title = "Event Title $it",
                        timestamp = "2024-10-28T12:00:00Z",
                        image = null,
                        date = "2024-10-28T12:00:00Z",
                        locationLine1 = "Location Line 1 $it",
                        locationLine2 = "Location Line 2",
                        phone = "123-456-7890"
                    )
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background),
            onAction = {}
        )
    }
}