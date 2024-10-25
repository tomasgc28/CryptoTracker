package com.plcoding.cryptotracker.app.ui.navigation

import android.util.Log.v
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.cryptotracker.features.crypto.coin_detail.CoinDetailScreen
import com.plcoding.cryptotracker.features.crypto.coin_list.CoinListAction
import com.plcoding.cryptotracker.features.crypto.coin_list.CoinListScreen
import com.plcoding.cryptotracker.features.crypto.coin_list.CoinListViewModel

@ExperimentalAnimationApi
@Composable
internal fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    padding: PaddingValues = PaddingValues(0.dp),
    viewModel: CoinListViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = CoinList,
        /** Change this to CoinListDetailPane to use Adaptive pane */
        modifier = modifier,
    ) {
        addCoinListDetailPane(
            padding = padding,
            viewModel = viewModel,
        )

        /**
         * Use regular navigation and not use Adaptive Pane
         */
        addCoinList(
            padding = padding,
            navController = navController,
            viewModel = viewModel,
        )

        addCoinDetail(
            padding = padding,
            viewModel = viewModel,
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addCoinListDetailPane(
    padding: PaddingValues,
    viewModel: CoinListViewModel,
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
private fun NavGraphBuilder.addCoinList(
    padding: PaddingValues,
    navController: NavHostController,
    viewModel: CoinListViewModel,
) {
    composable<CoinList>
    {
        val state by viewModel.state.collectAsStateWithLifecycle()
        CoinListScreen(
            modifier = Modifier.padding(padding),
            state = state,
            onAction = { action ->
                viewModel.onAction(action)
                when (action) {
                    is CoinListAction.OnCoinClick -> {
                        navController.navigate(CoinDetail)
                    }
                }
            }
        )
    }
}

@ExperimentalAnimationApi
private fun NavGraphBuilder.addCoinDetail(
    padding: PaddingValues,
    viewModel: CoinListViewModel,
) {
    composable<CoinDetail>
    {
        val state by viewModel.state.collectAsStateWithLifecycle()
        CoinDetailScreen(modifier = Modifier.padding(padding), state = state)
    }
}
