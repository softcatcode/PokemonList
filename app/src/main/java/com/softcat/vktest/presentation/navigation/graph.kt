package com.softcat.vktest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.softcat.vktest.domain.entities.Pokemon

val pokemonInfoArguments = listOf(
    navArgument(
        name = Screen.POKEMON_JSON_KEY,
        builder = { type = Pokemon.NavigationType }
    )
)

@Composable
fun LaunchPokemonInfo(navBackStackEntry: NavBackStackEntry, content: @Composable (Pokemon) -> Unit) {
    val args = navBackStackEntry.arguments ?: throw RuntimeException("NavBackStackEntry is null.")
    val pokemon = Pokemon.NavigationType[args, Pokemon.NavigationType.name]
        ?: throw RuntimeException("No pokemon in NavBackStackEntry.arguments.")
    content(pokemon)
}

@Composable
fun AppNavGraph(
    navController: NavHostController,
    pokemonListScreenContent: @Composable () -> Unit,
    pokemonInfoScreenContent: @Composable (Pokemon) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {
        composable(Screen.PokemonList.route) { pokemonListScreenContent() }

        composable(
            route = Screen.PokemonInfo.route,
            arguments = pokemonInfoArguments,
            content = { navBackStackEntry -> LaunchPokemonInfo(navBackStackEntry, pokemonInfoScreenContent) }
        )
    }
}