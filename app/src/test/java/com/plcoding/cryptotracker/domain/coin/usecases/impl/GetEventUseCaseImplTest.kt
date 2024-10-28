package com.plcoding.cryptotracker.domain.event.usecases.impl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.data.repositories.EventRepository
import com.plcoding.cryptotracker.domain.coin.model.Event
import com.plcoding.cryptotracker.domain.coin.usecases.GetEventUseCase
import com.plcoding.cryptotracker.domain.coin.usecases.impl.GetEventsUseCaseImpl

@OptIn(ExperimentalCoroutinesApi::class)
class GetEventsUseCaseImplTest {

    @Mock
    private lateinit var eventRepository: EventRepository

    private lateinit var getEventsUseCase: GetEventUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        eventRepository = mock()
        getEventsUseCase = GetEventsUseCaseImpl(eventRepository)
    }

    @Test
    fun `getEvents() should return list of events on success`() = runTest {
        // Arrange
        val eventList = listOf(
            Event(
                id = 1,
                description = "Description for Event 1",
                title = "Sample Event 1",
                timestamp = "2024-10-28T12:00:00Z",
                image = "https://example.com/event1.jpg",
                date = "2024-10-28",
                locationLine1 = "Location 1",
                locationLine2 = "City 1",
                phone = "123-456-7890"
            ),
            Event(
                id = 2,
                description = "Description for Event 2",
                title = "Sample Event 2",
                timestamp = "2024-10-29T12:00:00Z",
                image = "https://example.com/event2.jpg",
                date = "2024-10-29",
                locationLine1 = "Location 2",
                locationLine2 = "City 2",
                phone = "098-765-4321"
            )
        )
        whenever(eventRepository.getEvents()).thenReturn(Result.Success(eventList))

        // Act
        val result = getEventsUseCase.getEvents()

        // Assert
        assertEquals(Result.Success(eventList), result)
    }

    @Test
    fun `getEvents() should return NetworkError on failure`() = runTest {
        // Arrange
        whenever(eventRepository.getEvents()).thenReturn(Result.Error(NetworkError.NO_INTERNET))

        // Act
        val result = getEventsUseCase.getEvents()

        // Assert
        assertEquals(Result.Error(NetworkError.NO_INTERNET), result)
    }
}
