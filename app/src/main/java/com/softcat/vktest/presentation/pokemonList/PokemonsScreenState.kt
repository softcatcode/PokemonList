package com.softcat.vktest.presentation.pokemonList

import com.softcat.vktest.domain.entities.Pokemon

sealed class PokemonsScreenState {
    data object Initial: PokemonsScreenState()

    data object Loading: PokemonsScreenState()

    data class Error(
        val message: String
    ): PokemonsScreenState()

    data class Content(
        val pokemons: List<Pokemon>,
        val nextDataLoading: Boolean = false
    ): PokemonsScreenState()
}