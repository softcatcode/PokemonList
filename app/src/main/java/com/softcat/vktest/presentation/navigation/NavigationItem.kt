package com.softcat.vktest.presentation.navigation

sealed class NavigationItem(
    val screen: Screen
) {
    data object PokemonList: NavigationItem( screen = Screen.PokemonList )

    data object PokemonInfo: NavigationItem( screen = Screen.PokemonInfo )
}