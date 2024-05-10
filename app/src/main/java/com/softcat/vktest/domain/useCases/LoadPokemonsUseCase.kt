package com.softcat.vktest.domain.useCases

import com.softcat.vktest.domain.interfaces.PokemonRepositoryInterface
import javax.inject.Inject

class LoadPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepositoryInterface
) {
    suspend operator fun invoke() = repository.loadPokemons()
}