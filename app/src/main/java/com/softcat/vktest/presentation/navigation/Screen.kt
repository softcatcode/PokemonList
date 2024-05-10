package com.softcat.vktest.presentation.navigation

sealed class Screen(val route: String) {
    data object PokemonList: Screen(POKEMONS_LIST_ROUTE)

    data object PokemonInfo: Screen(POKEMON_INFO_ROUTE)

    companion object {
        private const val POKEMONS_LIST_ROUTE = "pokemon_list"
        private const val POKEMON_INFO_ROUTE = "pokemon_info"
    }
}