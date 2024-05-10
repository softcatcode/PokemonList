package com.softcat.vktest.domain.useCases

import com.softcat.vktest.domain.interfaces.PokemonRepositoryInterface
import javax.inject.Inject

class GetPokemonFlowUseCase @Inject constructor(
    private val repository: PokemonRepositoryInterface
) {
    operator fun invoke() = repository.getPokemonFlow()
}