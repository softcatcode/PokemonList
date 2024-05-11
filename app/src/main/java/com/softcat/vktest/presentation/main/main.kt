package com.softcat.vktest.presentation.main

import androidx.compose.runtime.Composable
import com.softcat.vktest.presentation.navigation.AppNavGraph
import com.softcat.vktest.presentation.navigation.NavigationState.Companion.rememberNavigationState
import com.softcat.vktest.presentation.pokemonInfo.PokemonInfoScreen
import com.softcat.vktest.presentation.pokemonList.PokemonListScreen

@Composable
fun PokemonAppMainScreen() {
    val navState = rememberNavigationState()

    AppNavGraph(
        navController = navState.navController,

        pokemonListScreenContent = {
            PokemonListScreen { pokemon ->
                navState.navigateToPokemonInfo(pokemon)
            }
        },

        pokemonInfoScreenContent = {
            PokemonInfoScreen(it)
        }
    )
}