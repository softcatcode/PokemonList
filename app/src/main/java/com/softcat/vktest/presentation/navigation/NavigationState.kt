package com.softcat.vktest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.softcat.vktest.domain.entities.Pokemon

class NavigationState(
    val navController: NavHostController
) {

    fun navigateToPokemonInfo(pokemon: Pokemon) {
        navController.navigate(Screen.PokemonInfo.getPathWithArgs(pokemon)) {
            restoreState = true
            launchSingleTop = true
        }
    }

    companion object {
        @Composable
        fun rememberNavigationState(
            controller: NavHostController = rememberNavController()
        ) = remember { NavigationState(controller) }
    }

}