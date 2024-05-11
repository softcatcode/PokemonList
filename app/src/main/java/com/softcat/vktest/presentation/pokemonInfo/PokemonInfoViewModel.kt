package com.softcat.vktest.presentation.pokemonInfo

import androidx.lifecycle.ViewModel
import com.softcat.vktest.domain.entities.Pokemon
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(
    private val pokemon: Pokemon
): ViewModel() {

}