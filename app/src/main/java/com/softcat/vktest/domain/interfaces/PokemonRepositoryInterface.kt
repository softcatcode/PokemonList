package com.softcat.vktest.domain.interfaces

import com.softcat.vktest.domain.entities.Pokemon
import kotlinx.coroutines.flow.StateFlow

interface PokemonRepositoryInterface {

    fun loadPokemons()

    fun getPokemonFlow(): StateFlow< List<Pokemon> >
}