package com.plcoding.cryptotracker.app.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.plcoding.cryptotracker.features.crypto.coin_detail.coinDetailScreen
import com.plcoding.cryptotracker.features.crypto.coin_detail.navigateToCoinDetail
import com.plcoding.cryptotracker.features.crypto.coin_list.GRAPH_HOME_ROUTE
import com.plcoding.cryptotracker.features.crypto.coin_list.homeGraph

@ExperimentalAnimationApi
@Composable
internal fun CoinAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = GRAPH_HOME_ROUTE.route,
        modifier = modifier,
    ) {

        homeGraph(
            onCoinClicked = { rootRoute, coinId ->
                navController.navigateToCoinDetail(rootRoute, coinId)
            },
            nestedGraphs = { rootRoute ->
                addCoinDetailScreen(rootRoute, navController)
            }
        )
    }
}

private fun NavGraphBuilder.addCoinDetailScreen(
    rootRoute: DestinationRoute,
    navController: NavHostController,
) {
    coinDetailScreen(
        rootRoute = rootRoute,
        onBack = navController::popBackStack,
    )
}

//
//        addCoinListDetailPane(
//            padding = padding,
//            viewModel = viewModel,
//        )
//
//        /**
//         * Use regular navigation and not use Adaptive Pane
//         */
//        addCoinList(
//            padding = padding,
//            navController = navController,
//            viewModel = viewModel,
//        )
//
//        addCoinDetail(
//            padding = padding,
//            viewModel = viewModel,
//        )
//}
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addCoinListDetailPane(
//    padding: PaddingValues,
//    viewModel: CoinListViewModel,
//) {
//    composable<CoinListDetailPane>
//    {
//        AdaptiveCoinListDetailPane(
//            modifier = Modifier.padding(padding),
//            viewModel = viewModel,
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addCoinList(
//    padding: PaddingValues,
//    navController: NavHostController,
//    viewModel: CoinListViewModel,
//) {
//    composable<CoinList>
//    {
//        val state by viewModel.state.collectAsStateWithLifecycle()
//        CoinListScreen(
//            modifier = Modifier.padding(padding),
//            state = state,
//            onAction = { action ->
//                viewModel.onAction(action)
//                when (action) {
//                    is CoinListAction.OnCoinClick -> {
//                        navController.navigate(CoinDetail)
//                    }
//                }
//            }
//        )
//    }
//}
//
//@ExperimentalAnimationApi
//private fun NavGraphBuilder.addCoinDetail(
//    padding: PaddingValues,
//    viewModel: CoinListViewModel,
//) {
//    composable<CoinDetail>
//    {
//        val state by viewModel.state.collectAsStateWithLifecycle()
//        CoinDetailScreen(modifier = Modifier.padding(padding), state = state)
//    }
//}
