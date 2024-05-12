package com.softcat.vktest.presentation.pokemonInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.softcat.vktest.domain.entities.Pokemon
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(
    pokemon: Pokemon
): ViewModel() {

    private val _state = MutableLiveData<PokemonInfoScreenState>(PokemonInfoScreenState.Initial)
    val state: LiveData<PokemonInfoScreenState> = _state

    init {
        _state.value = PokemonInfoScreenState.Content(pokemon)
    }
}