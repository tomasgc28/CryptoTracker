package com.plcoding.cryptotracker.app.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.cryptotracker.features.crypto.coin_detail.EventDetailsScreen
import com.plcoding.cryptotracker.features.crypto.coin_list.EventListAction
import com.plcoding.cryptotracker.features.crypto.coin_list.EventListScreen
import com.plcoding.cryptotracker.features.crypto.coin_list.EventListViewModel

@ExperimentalAnimationApi
@Composable
internal fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    padding: PaddingValues = PaddingValues(0.dp),
    viewModel: EventListViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = CoinListDetailPane,
        modifier = modifier,
    ) {
        addEventListDetailPane(
            padding = padding,
            viewModel = viewModel,
        )

        addEventList(
            padding = padding,
            navController = navController,
            viewModel = viewModel,
        )

        addEventDetail(
            padding = padding,
            viewModel = viewModel,
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addEventListDetailPane(
    padding: PaddingValues,
    viewModel: EventListViewModel,
) {
    composable<CoinListDetailPane>
    {
        AdaptiveCoinListDetailPane(
            modifier = Modifier.padding(padding),
            viewModel = viewModel,
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addEventList(
    padding: PaddingValues,
    navController: NavHostController,
    viewModel: EventListViewModel,
) {
    composable<CoinList>
    {
        val state by viewModel.state.collectAsStateWithLifecycle()
        EventListScreen(
            modifier = Modifier.padding(padding),
            state = state,
            onAction = { action ->
                when (action) {
                    is EventListAction.OnEventClick -> {
                        navController.navigate(CoinDetail)
                    }
                }
            }
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addEventDetail(
    padding: PaddingValues,
    viewModel: EventListViewModel,
) {
    composable<CoinDetail>
    {
        val state by viewModel.state.collectAsStateWithLifecycle()
        EventDetailsScreen(modifier = Modifier.padding(padding), event = state.event.first())
    }
}
