package com.plcoding.cryptotracker.features.crypto.coin_list

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.plcoding.cryptotracker.app.ui.navigation.DestinationRoute
import com.plcoding.cryptotracker.core.designsystem.util.ObserveAsEvents
import com.plcoding.cryptotracker.core.designsystem.util.toString


val GRAPH_HOME_ROUTE = DestinationRoute("home_graph_route")
private const val ROUTE_HOME_SCREEN = "home"

fun NavGraphBuilder.homeGraph(
    onCoinClicked: (rootRoute: DestinationRoute, coinId: String) -> Unit,
    nestedGraphs: NavGraphBuilder.(DestinationRoute) -> Unit
) {
    navigation(
        route = GRAPH_HOME_ROUTE.route,
        startDestination = "$GRAPH_HOME_ROUTE/$ROUTE_HOME_SCREEN"
    ) {
        composable(
            route = "$GRAPH_HOME_ROUTE/$ROUTE_HOME_SCREEN",
        ) {
            val viewModel = hiltViewModel<CoinListViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()
            val context = LocalContext.current
            ObserveAsEvents(events = viewModel.events) { event ->
                when(event) {
                    is CoinListEvent.Error -> {
                        Toast.makeText(
                            context,
                            event.error.toString(context),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            CoinListScreen(
                state = state,
                onCoinClicked = {
                    onCoinClicked(GRAPH_HOME_ROUTE,it)
                }
            )
        }

        nestedGraphs(GRAPH_HOME_ROUTE)
    }
}