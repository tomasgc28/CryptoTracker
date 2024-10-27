package com.plcoding.cryptotracker.domain.coin.usecases.impl

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
import com.plcoding.cryptotracker.data.repositories.CoinsRepository
import com.plcoding.cryptotracker.domain.coin.model.Coin
import com.plcoding.cryptotracker.domain.coin.usecases.GetCoinsUseCase

@OptIn(ExperimentalCoroutinesApi::class)
class GetCoinsUseCaseImplTest {

    @Mock
    private lateinit var coinsRepository: CoinsRepository

    private lateinit var getCoinsUseCase: GetCoinsUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        coinsRepository = mock()
        getCoinsUseCase = GetCoinsUseCaseImpl(coinsRepository)
    }

    @Test
    fun `getCoins() should return list of coins on success`() = runTest {
        // Arrange
        val coinList = listOf(
            Coin("1", 1, "Bitcoin", "BTC", 1_000_000.0, 50_000.0, 5.0),
            Coin("2", 2, "Ethereum", "ETH", 500_000.0, 3_500.0, 3.0)
        )
        whenever(coinsRepository.getCoins()).thenReturn(Result.Success(coinList))

        // Act
        val result = getCoinsUseCase.getCoins()

        // Assert
        assertEquals(Result.Success(coinList), result)
    }

    @Test
    fun `getCoins() should return NetworkError on failure`() = runTest {
        // Arrange
        whenever(coinsRepository.getCoins()).thenReturn(Result.Error(NetworkError.NO_INTERNET))

        // Act
        val result = getCoinsUseCase.getCoins()

        // Assert
        assertEquals(Result.Error(NetworkError.NO_INTERNET), result)
    }
}
