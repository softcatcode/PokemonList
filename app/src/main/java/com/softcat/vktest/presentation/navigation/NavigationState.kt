package com.softcat.vktest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navController: NavHostController
) {

    val items = listOf(NavigationItem.PokemonList, NavigationItem.PokemonInfo)

    fun navigate(route: String) = navController.navigate(route) {
        restoreState = true
        launchSingleTop = true
    }

    companion object {
        @Composable
        fun rememberNavigationState(
            controller: NavHostController = rememberNavController()
        ) = remember { NavigationState(controller) }
    }

}