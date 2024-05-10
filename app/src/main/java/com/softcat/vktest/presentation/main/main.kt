package com.softcat.vktest.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.softcat.vktest.presentation.navigation.AppNavGraph
import com.softcat.vktest.presentation.pokemonInfo.PokemonInfoScreen
import com.softcat.vktest.presentation.pokemonList.PokemonListScreen

@Composable
fun PokemonAppMainScreen() {
    val navController = rememberNavController()

    AppNavGraph(
        navController = navController,

        pokemonListScreenContent = {
            PokemonListScreen { pokemon ->

            }
        },

        pokemonInfoScreenContent = {
            PokemonInfoScreen()
        }
    )
}