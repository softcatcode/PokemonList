package com.softcat.vktest.data.mappers

import com.softcat.vktest.data.network.dtoModels.LoadPokemonsResponseDto
import com.softcat.vktest.data.network.dtoModels.PokemonInfoDto
import com.softcat.vktest.domain.entities.Pokemon
import javax.inject.Inject

class DtoMapper @Inject constructor() {

    fun mapResponseToPokemonList(
        response: LoadPokemonsResponseDto,
        infoDtoObjects: List<PokemonInfoDto>
    ) = response.pokemonList.mapIndexed { index, model ->
        Pokemon(
            name = model.name,
            infoUrl = model.infoUrl,
            iconUrl = infoDtoObjects[index].texture.frontDefault
        )
    }
}