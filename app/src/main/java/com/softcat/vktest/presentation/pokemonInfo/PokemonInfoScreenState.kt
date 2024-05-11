package com.softcat.vktest.presentation.pokemonInfo

import com.softcat.vktest.domain.entities.Pokemon

sealed class PokemonInfoScreenState {
    data object Initial: PokemonInfoScreenState()

    data class Content(val pokemon: Pokemon): PokemonInfoScreenState()
}