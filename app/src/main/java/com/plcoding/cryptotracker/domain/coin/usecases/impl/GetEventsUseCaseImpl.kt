package com.plcoding.cryptotracker.domain.coin.usecases.impl

import com.plcoding.cryptotracker.core.domain.util.NetworkError
import com.plcoding.cryptotracker.core.domain.util.Result
import com.plcoding.cryptotracker.data.repositories.EventRepository
import com.plcoding.cryptotracker.domain.coin.model.Event
import com.plcoding.cryptotracker.domain.coin.usecases.GetEventUseCase
import javax.inject.Inject

// Sample mock data for events
private val mockEvents = listOf(
    Event(
        id = 1,
        title = "Stop Rebel Forces",
        description = "Rebel Forces spotted on Hoth. Quell their rebellion for the Empire.",
        timestamp = "2015-06-18T17:02:02.614Z",
        image = "https://raw.githubusercontent.com/phunware-services/dev-interview-homework/master/Images/Battle_of_Hoth.jpg",
        date = "2015-06-18T23:30:00.000Z",
        locationLine1 = "Hoth",
        locationLine2 = "Anoat System"
    ),
    Event(
        id = 2,
        title = "Sith Academy Orientation",
        description = "All force-sensitive members of the Empire must report to the Sith Academy on Korriban...",
        timestamp = "2015-06-18T21:52:42.865Z",
        image = "https://raw.githubusercontent.com/phunware-services/dev-interview-homework/master/Images/Korriban_Valley_TOR.jpg",
        date = "2015-09-27T15:00:00.000Z",
        locationLine1 = "Korriban",
        locationLine2 = "Horuset System",
        phone = "1 (800) 545-5334"
    ),
    // Add other mock event data here...
)

// Implementation of the use case with mock data as a fallback
class GetEventsUseCaseImpl @Inject constructor(
    private val eventRepository: EventRepository?
) : GetEventUseCase {

    override suspend fun getEvents(): Result<List<Event>, NetworkError> {
        // Use repository if provided, otherwise return mock data
        return  Result.Success(mockEvents)
//        if (eventRepository != null) {
//            eventRepository.getEvents()
//        } else {

//        }
    }
}
