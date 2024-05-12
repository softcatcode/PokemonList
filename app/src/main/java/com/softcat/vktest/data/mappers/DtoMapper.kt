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
        val info = infoDtoObjects[index]
        val texture = info.texture
        Pokemon(
            id = info.id,
            name = model.name,
            infoUrl = model.infoUrl,
            frontIconUrl = texture.frontDefault,
            backIconUrl = texture.backDefault,
            frontFemaleIconUrl = texture.frontFemale,
            backFemaleIconUrl = texture.backFemale,
            frontShinyIconUrl = texture.frontShiny,
            backShinyIconUrl = texture.backShiny,
            types = mapPokemonTypeDtoToEntityList(info.types),
            characteristics = mapPokemonCharacteristicDtoToEntityList(info.characteristics),
            experience = info.experience,
            weight = info.weight,
            height = info.height
        )
    }
}