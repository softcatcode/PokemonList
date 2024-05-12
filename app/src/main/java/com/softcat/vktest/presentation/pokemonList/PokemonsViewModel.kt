package com.softcat.vktest.presentation.pokemonList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softcat.vktest.domain.entities.Pokemon
import com.softcat.vktest.domain.useCases.GetErrorFlowUseCase
import com.softcat.vktest.domain.useCases.GetPokemonFlowUseCase
import com.softcat.vktest.domain.useCases.LoadPokemonsUseCase
import com.softcat.vktest.presentation.extensions.mergeWith
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonsViewModel @Inject constructor(
    private val loadPokemonsUseCase: LoadPokemonsUseCase,
    getPokemonFlowUseCase: GetPokemonFlowUseCase,
    getErrorFlowUseCase: GetErrorFlowUseCase
): ViewModel() {

    private val stateUpdate = MutableSharedFlow<PokemonsScreenState>()
    private val pokemonFlow: StateFlow<List<Pokemon>> = getPokemonFlowUseCase()

    private val exceptionHandler = CoroutineExceptionHandler { scope, throwable ->
        viewModelScope.launch(scope) {
            stateUpdate.emit(PokemonsScreenState.Error(throwable.toString()))
        }
    }

    private val errorFlow = getErrorFlowUseCase().map {
        stateUpdate.emit(PokemonsScreenState.Error(it) as PokemonsScreenState)
    }

    val state = pokemonFlow
        .filter { it.isNotEmpty() }
        .map { PokemonsScreenState.Content(it) as PokemonsScreenState }
        .onStart { emit(PokemonsScreenState.Loading) }
        .mergeWith(stateUpdate)
        .mergeWith(errorFlow)

    fun loadPokemonsPage() {
        viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            stateUpdate.emit(
                PokemonsScreenState.Content(
                    pokemons = pokemonFlow.value,
                    nextDataLoading = true
                )
            )
            loadPokemonsUseCase()
        }
    }
}