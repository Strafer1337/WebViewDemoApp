package com.strafer.webviewapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {

    @Serializable
    object HomeScreen

    @Serializable
    data class WebViewScreen(val link: String)
}

@Composable
fun SetupNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screens.HomeScreen,
        modifier = modifier
    ) {
        composable<Screens.HomeScreen> {
            HomeScreen(
                onButtonClick = { link ->
                    navController.navigate(
                        route = Screens.WebViewScreen(link)
                    )
                }
            )
        }
        composable<Screens.WebViewScreen> { backStackEntry ->
            val route: Screens.WebViewScreen = backStackEntry.toRoute()
            WebViewScreen(link = route.link)
        }
    }
}