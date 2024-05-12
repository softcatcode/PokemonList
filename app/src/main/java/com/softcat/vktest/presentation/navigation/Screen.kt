package com.softcat.vktest.presentation.navigation

import android.net.Uri
import com.google.gson.Gson
import com.softcat.vktest.domain.entities.Pokemon

sealed class Screen(val route: String) {
    data object PokemonList: Screen(POKEMONS_LIST_ROUTE)

    data object PokemonInfo: Screen(POKEMON_INFO_ROUTE) {

        fun getPathWithArgs(pokemon: Pokemon): String {
            val json = Gson().toJson(pokemon)
            val encoded = Uri.encode(json)
            return "$POKEMON_INFO_ROUTE_FOR_ARGS/$encoded"
        }
    }

    companion object {
        private const val POKEMONS_LIST_ROUTE = "pokemon_list"
        const val POKEMON_JSON_KEY = "pokemon"
        private const val POKEMON_INFO_ROUTE_FOR_ARGS = "pokemon_info"
        private const val POKEMON_INFO_ROUTE = "$POKEMON_INFO_ROUTE_FOR_ARGS/{$POKEMON_JSON_KEY}"
    }
}