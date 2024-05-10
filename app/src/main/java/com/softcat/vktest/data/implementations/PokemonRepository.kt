package com.softcat.vktest.data.implementations

import com.softcat.vktest.data.mappers.DtoMapper
import com.softcat.vktest.data.network.api.PokemonApiService
import com.softcat.vktest.domain.entities.Pokemon
import com.softcat.vktest.domain.interfaces.PokemonRepositoryInterface
import com.softcat.vktest.presentation.extensions.mergeWith
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokemonApiService,
    private val mapper: DtoMapper
): PokemonRepositoryInterface {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val loadPokemonsRequest = MutableSharedFlow<Unit>(replay = 1)
    private val pokemonListUpdate = MutableSharedFlow< List<Pokemon> >()
    private val pokemonListFlow = flow {
        loadPokemonsRequest.emit(Unit)
        loadPokemonsRequest.collect {
            loadPokemonList()
            emit(pokemonList)
        }
    }

    private val _pokemonList = mutableListOf<Pokemon>()
    private val pokemonList: List<Pokemon>
        get() = _pokemonList.toList()


    private var loadPokemonsOffset = 0

    private suspend fun loadPokemonList() {
        val response = apiService.loadPokemons(
            offset = loadPokemonsOffset,
            limit = POKEMONS_PACK_SIZE
        )
        val infoDtoObjects = response.pokemonList.map {
            apiService.loadPokemonInfo(it.infoUrl)
        }
        val newPokemons = mapper.mapResponseToPokemonList(response, infoDtoObjects)
        _pokemonList.addAll(newPokemons)
        loadPokemonsOffset += newPokemons.size
    }

    override suspend fun loadPokemons() {
        loadPokemonsRequest.emit(Unit)
    }

    override fun getPokemonFlow() = pokemonListFlow
        .mergeWith(pokemonListUpdate)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = listOf()
        )

    companion object {
        private const val POKEMONS_PACK_SIZE = 10
    }
}