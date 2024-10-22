package com.plcoding.cryptotracker.app.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@ExperimentalAnimationApi
@Composable
internal fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    padding: PaddingValues = PaddingValues(0.dp),
) {
    NavHost(
        navController = navController,
        startDestination = CoinListDetailPane,
        modifier = modifier,
    ) {
        addCoinListDetailPane(
            padding = padding,
            navController = navController,
        )
    }
}


@ExperimentalAnimationApi
private fun NavGraphBuilder.addCoinListDetailPane(
    padding: PaddingValues,
    navController: NavHostController,
) {
    composable<CoinListDetailPane>
    {
        AdaptiveCoinListDetailPane(
            modifier = Modifier.padding(padding)
        )
    }

}
