package com.softcat.vktest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navController: NavHostController,
    pokemonListScreenContent: @Composable () -> Unit,
    pokemonInfoScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(Screen.PokemonList.route) { pokemonListScreenContent() }
        composable(Screen.PokemonInfo.route) { pokemonInfoScreenContent() }
    }
}