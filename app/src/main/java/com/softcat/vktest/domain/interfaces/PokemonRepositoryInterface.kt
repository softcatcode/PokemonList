package com.softcat.vktest.domain.interfaces

import com.softcat.vktest.domain.entities.Pokemon
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface PokemonRepositoryInterface {

    suspend fun loadPokemons()

    fun getPokemonFlow(): StateFlow< List<Pokemon> >

    fun getErrorFlow(): SharedFlow<String>
}