package com.softcat.vktest.data.mappers

import com.softcat.vktest.data.network.dtoModels.CharacteristicDto
import com.softcat.vktest.data.network.dtoModels.LoadPokemonsResponseDto
import com.softcat.vktest.data.network.dtoModels.PokemonInfoDto
import com.softcat.vktest.data.network.dtoModels.PokemonTypeDto
import com.softcat.vktest.domain.entities.Pokemon
import com.softcat.vktest.domain.entities.PokemonCharacteristic
import com.softcat.vktest.domain.entities.PokemonType
import javax.inject.Inject

class DtoMapper @Inject constructor() {

    private fun mapPokemonTypeDtoToEntityList(list: List<PokemonTypeDto>) = list.map {
        PokemonType(it.type.name)
    }

    private fun mapPokemonCharacteristicDtoToEntityList(list: List<CharacteristicDto>) = list.map {
        PokemonCharacteristic(it.stat.name, it.value)
    }

    fun mapResponseToPokemonList(
        response: LoadPokemonsResponseDto,
        infoDtoObjects: List<PokemonInfoDto>
    ) = response.pokemonList.mapIndexed { index, model ->
        val texture = infoDtoObjects[index].texture
        Pokemon(
            id = model.id,
            name = model.name,
            infoUrl = model.infoUrl,
            frontIconUrl = texture.frontDefault,
            backIconUrl = texture.backDefault,
            frontFemaleIconUrl = texture.frontFemale,
            backFemaleIconUrl = texture.backFemale,
            types = mapPokemonTypeDtoToEntityList(model.types),
            characteristics = mapPokemonCharacteristicDtoToEntityList(model.characteristics),
            experience = model.experience,
            weight = model.weight,
            height = model.height
        )
    }
}